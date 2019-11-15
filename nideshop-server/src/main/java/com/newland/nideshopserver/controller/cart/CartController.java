package com.newland.nideshopserver.controller.cart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.ls.LSInput;

import com.alibaba.fastjson.JSON;
import com.newland.nideshopserver.model.NideshopAddress;
import com.newland.nideshopserver.model.NideshopCart;
import com.newland.nideshopserver.model.NideshopGoods;
import com.newland.nideshopserver.model.NideshopGoodsSpecification;
import com.newland.nideshopserver.model.NideshopProduct;
import com.newland.nideshopserver.model.NideshopUserCoupon;
import com.newland.nideshopserver.model.dto.Result;
import com.newland.nideshopserver.service.AddressService;
import com.newland.nideshopserver.service.CartService;
import com.newland.nideshopserver.service.GoodsService;
import com.newland.nideshopserver.service.GoodsSpecificationService;
import com.newland.nideshopserver.service.ProductService;
import com.newland.nideshopserver.service.RegionService;
import com.newland.nideshopserver.service.SpecificationService;
import com.newland.nideshopserver.service.UserCouponService;
import com.newland.nideshopserver.service.UserService;
import com.newland.nideshopserver.utis.RequestParamParseUtil;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wangzb
 * @date: 2019年10月18日 下午3:57:22
 * @version V1.0
 */
@RestController
public class CartController {

	@Autowired
	private CartService cartService;

	@Autowired
	private GoodsService goodsService;

	@Autowired
	private ProductService productService;

	@Autowired
	private GoodsSpecificationService goodsSpecificationService;

	@Autowired
	private SpecificationService specificationService;

	@Autowired
	private UserService userService;

	@Autowired
	private AddressService addressService;

	@Autowired
	private RequestParamParseUtil requestParamUtil;

	@Autowired
	private RegionService regionService;

	@Autowired
	private UserCouponService userCouponService;

	// 获取购物车商品的总件件数
	@RequestMapping("/cart/goodscount")
	public Result goodscount(HttpServletRequest request) {

		Map<String, Object> cart = getCart(requestParamUtil.getUserId(request));
		Map<String, Object> cartTotal = (Map<String, Object>) cart.get("cartTotal");
		cartTotal.remove("goodsAmount");
		cartTotal.remove("checkedGoodsCount");
		cartTotal.remove("checkedGoodsAmount");

		HashMap<String, Object> data = new HashMap<>();
		data.put("cartTotal", cartTotal);

		Result result = new Result();
		result.setData(data);
		return result;
	}

	/**
	 * 获取购物车中的数据
	 * 
	 * @returns {Promise.<{cartList: *, cartTotal: {goodsCount: number, goodsAmount:
	 *          number, checkedGoodsCount: number, checkedGoodsAmount: number}}>}
	 */
	public Map<String, Object> getCart(Integer userId) {

		List<NideshopCart> cartList = cartService.cartList(userId, "1");
		int goodsCount = 0;
		BigDecimal goodsAmount = new BigDecimal(0);
		int checkedGoodsCount = 0;
		BigDecimal checkedGoodsAmount = new BigDecimal(0);

		for (int i = 0; i < cartList.size(); i++) {
			NideshopCart cartItem = cartList.get(i);
			goodsCount += cartItem.getNumber();
			goodsAmount = goodsAmount.add(cartItem.getRetailPrice().multiply(new BigDecimal(cartItem.getNumber())));

			if (cartItem.getChecked() != null) {
				checkedGoodsCount += cartItem.getNumber();
				checkedGoodsAmount = checkedGoodsAmount
						.add(cartItem.getRetailPrice().multiply(new BigDecimal(cartItem.getNumber())));

			}

			cartItem.setListPicUrl(goodsService.getListPicUrl(cartItem.getGoodsId()));
		}
		HashMap<String, Object> cartTotal = new HashMap<>();

		cartTotal.put("goodsCount", goodsCount);
		cartTotal.put("goodsAmount", goodsAmount);
		cartTotal.put("checkedGoodsCount", checkedGoodsCount);
		cartTotal.put("checkedGoodsAmount", checkedGoodsAmount);
		HashMap<String, Object> cart = new HashMap<>();
		cart.put("cartList", cartList);
		cart.put("cartTotal", cartTotal);

		return cart;
	}

	@RequestMapping("cart/index")
	public Result index(HttpServletRequest request) {
		Result result = new Result();
		result.setData(getCart(requestParamUtil.getUserId(request)));
		return result;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/cart/add")
	public Result add(HttpServletRequest request, Integer goodsId, Integer productId, Integer number) {

		Integer userId = requestParamUtil.getUserId(request);

		Result result = new Result();
		NideshopGoods goodsInfo = goodsService.selectById(goodsId);

		// 判断商品是否可以购买
		if (goodsInfo == null || goodsInfo.getIsDelete() == 1) {
			result.setErrno(400);
			result.setErrmsg("商品已下架");
			return result;
		}

		NideshopProduct productInfo = productService.getProductInfo(goodsId, productId);
		if (productInfo == null || productInfo.getGoodsNumber() == null || productInfo.getGoodsNumber() < number) {
			result.setErrno(400);
			result.setErrmsg("库存不足");
			return result;
		}

		NideshopCart cartInfo = cartService.getCartInfo(userId, goodsId, productId);

		if (cartInfo == null) {
			// 添加操作

			// 添加规格名和值
			List<String> goodsSepcifitionValue = null;
			if (productInfo.getGoodsSpecificationIds() != null) {
				Example example = new Example(NideshopGoodsSpecification.class);
				example.selectProperties("value");
				Criteria criteria = example.createCriteria();
				criteria.andEqualTo("goodsId", goodsId);
				criteria.andIn("id", Arrays.asList(productInfo.getGoodsSpecificationIds().split("_")));

				goodsSepcifitionValue = goodsSpecificationService.selectByExample(example);

			}
			NideshopCart nideshopCart = new NideshopCart();
			nideshopCart.setGoodsId(goodsId);
			nideshopCart.setProductId(productId);
			nideshopCart.setGoodsSn(productInfo.getGoodsSn());
			nideshopCart.setGoodsName(goodsInfo.getName());
			nideshopCart.setListPicUrl(goodsInfo.getListPicUrl());
			nideshopCart.setNumber(number);
			nideshopCart.setSessionId("1");
			nideshopCart.setUserId(userId);
			nideshopCart.setRetailPrice(productInfo.getRetailPrice());
			nideshopCart.setMarketPrice(productInfo.getRetailPrice());
			nideshopCart.setGoodsSpecifitionNameValue(String.join(";", goodsSepcifitionValue));
			nideshopCart.setGoodsSpecifitionIds(productInfo.getGoodsSpecificationIds());
			nideshopCart.setChecked(1);

			cartService.thenAdd(nideshopCart, productId);

		} else {
			if (productInfo.getGoodsNumber() < number + cartInfo.getNumber()) {
				result.setErrno(400);
				result.setErrmsg("库存不足");
				return result;
			}
			cartService.incrementNumber(goodsId, productId, cartInfo.getId(), number);

		}

		result.setData(getCart(requestParamUtil.getUserId(request)));
		return result;

	}

	// 更新指定的购物车信息
	@RequestMapping("cart/update")
	public Result update(HttpServletRequest request, Integer goodsId, Integer productId, Integer id, Integer number) {
		Result result = new Result();

		Integer userId = requestParamUtil.getUserId(request);
		NideshopProduct productInfo = productService.getProductInfo(goodsId, productId);
		// 取得规格的信息,判断规格库存
		if (productInfo == null || productInfo.getGoodsNumber() == null || productInfo.getGoodsNumber() < number) {
			result.setErrno(400);
			result.setErrmsg("库存不足");
			return result;
		}

		// 判断是否已经存在product_id购物车商品
		NideshopCart cartInfo = cartService.getCartById(id);
		// 只是更新number
		if (cartInfo.getProductId().equals(productId)) {
			cartService.updateNumber(id, number);
			result.setData(getCart(requestParamUtil.getUserId(request)));
			return result;
		}

		NideshopCart newCartInfo = cartService.getCartInfo(userId, goodsId, productId);
		if (newCartInfo == null) {
			// 直接更新原来的cartInfo

			// 添加规格名和值
			List<NideshopGoodsSpecification> goodsSpecifition = new ArrayList<>();
			if (productInfo.getGoodsSpecificationIds() != null) {
				Example example = new Example(NideshopGoodsSpecification.class);
				Criteria criteria = example.createCriteria();
				criteria.andEqualTo("goodsId", goodsId);
				criteria.andIn("id", Arrays.asList(productInfo.getGoodsSpecificationIds().split("_")));
				goodsSpecifition = goodsSpecificationService.selectByExample(example);
				// 添加规格名

				ArrayList<Integer> goodsSpecifitionIds = new ArrayList<>();
				for (int i = 0; i < goodsSpecifition.size(); i++) {
					goodsSpecifitionIds.add(goodsSpecifition.get(i).getSpecificationId());
				}
				Map<Integer, String> goodsSpecifitionMap = specificationService.mapIdIn(goodsSpecifitionIds);
				for (int i = 0; i < goodsSpecifition.size(); i++) {
					NideshopGoodsSpecification specification = goodsSpecifition.get(i);
					specification.setName(goodsSpecifitionMap.get(specification.getSpecificationId()));
				}
			}

			NideshopCart cartData = new NideshopCart();
			cartData.setNumber(number);
			cartData.setGoodsSpecifitionNameValue(JSON.toJSONString(goodsSpecifition));
			cartData.setGoodsSpecifitionIds(productInfo.getGoodsSpecificationIds());
			cartData.setRetailPrice(productInfo.getRetailPrice());
			cartData.setMarketPrice(productInfo.getRetailPrice());
			cartData.setProductId(productId);
			cartData.setGoodsSn(productInfo.getGoodsSn());
			cartData.setId(id);
			cartService.update(cartData);
		} else {
			// 合并购物车已有的product信息，删除已有的数据
			Integer newNumber = number + newCartInfo.getNumber();

			if (productInfo == null || productInfo.getGoodsNumber() < newNumber) {
				result.setErrno(400);
				result.setErrmsg("库存不足");
				return result;
			}

			cartService.deleteById(newCartInfo.getId());

			NideshopCart cartData = new NideshopCart();
			cartData.setId(id);
			cartData.setNumber(newNumber);
			cartData.setGoodsSpecifitionNameValue(newCartInfo.getGoodsSpecifitionNameValue());
			cartData.setGoodsSpecifitionIds(newCartInfo.getGoodsSpecifitionIds());
			cartData.setRetailPrice(productInfo.getRetailPrice());
			cartData.setMarketPrice(productInfo.getRetailPrice());
			cartData.setProductId(productId);
			cartData.setGoodsSn(productInfo.getGoodsSn());
			cartService.update(cartData);
		}
		result.setData(getCart(userId));
		return result;
	}

	@RequestMapping("cart/checked")
	public Result checked(HttpServletRequest request, String productIds, Integer isChecked) {
		Result result = new Result();
		if (productIds == null) {
			result.setErrmsg("删除出错");
			return result;
		}

		String[] productId = productIds.split(",");
		cartService.updateChecked(productId, isChecked);

		result.setData(getCart(requestParamUtil.getUserId(request)));
		return result;
	}

	@RequestMapping("cart/delete")
	public Result delete(HttpServletRequest request, String productIds) {
		Result result = new Result();
		if (productIds == null) {
			result.setErrmsg("删除出错");
			return result;
		}

		String[] productId = productIds.split(",");
		cartService.deleteProductIdIn(productId);

		result.setData(getCart(requestParamUtil.getUserId(request)));
		return result;
	}

	/**
	 * 订单提交前的检验和填写相关订单信息
	 */
	@RequestMapping("cart/checkout")
	public Result checkout(Integer addressId, HttpServletRequest request) {

		Result result = new Result();
		NideshopAddress checkedAddress = null;
		// 选择的收货地址
		if (addressId == null||addressId==0) {
		
			checkedAddress = addressService.findUserDefaultAddress(requestParamUtil.getUserId(request));
		} else {
			checkedAddress = addressService.findAddress(addressId, requestParamUtil.getUserId(request));
		}

		System.out.println(JSON.toJSON(checkedAddress));
		
		if (checkedAddress != null) {
			checkedAddress.setProvinceName(regionService.getRegionName(checkedAddress.getProvinceId()));
			checkedAddress.setCityName(regionService.getRegionName(checkedAddress.getCityId()));
			checkedAddress.setDistrictName(regionService.getRegionName(checkedAddress.getDistrictId()));
			checkedAddress.setFullRegion(
					checkedAddress.getProvinceName() + checkedAddress.getCityName() + checkedAddress.getDistrictName());

		}

		// 根据收货地址计算运费
		BigDecimal freightPrice = new BigDecimal(0);

		// 获取要购买的商品
		List<NideshopCart> checkedGoodsList = new ArrayList<>();
		Map<String, Object> cartData = getCart(requestParamUtil.getUserId(request));
		List<NideshopCart> cartList = (List<NideshopCart>) cartData.get("cartList");
		for (int i = 0; i < cartList.size(); i++) {
			if (cartList.get(i).getChecked() == 1) {
				checkedGoodsList.add(cartList.get(i));
			}
		}

		// 获取可用的优惠券信息，功能还示实现
		List<NideshopUserCoupon> couponList = userCouponService.selectAll();

		BigDecimal couponPrice = new BigDecimal(0);// 使用优惠券减免的金额
		// 计算订单的费用
		Map<String, Object> cartTotal = (Map<String, Object>) cartData.get("cartTotal");
		BigDecimal goodsTotalPrice = (BigDecimal) cartTotal.get("checkedGoodsAmount");// 商品总价
		BigDecimal orderTotalPrice = goodsTotalPrice.add(freightPrice).subtract(couponPrice);// 订单的总价
		BigDecimal actualPrice = orderTotalPrice.subtract(new BigDecimal(0)); // 减去其它支付的金额后，要实际支付的金额

		HashMap<String, Object> data = new HashMap<>();

		if(checkedAddress==null) {
			checkedAddress=new NideshopAddress();
		}
		
		data.put("checkedAddress", checkedAddress);

		data.put("freightPrice", freightPrice);
		data.put("checkedCoupon", new HashMap<>());
		data.put("couponList", couponList);
		data.put("couponPrice", couponPrice);
		data.put("checkedGoodsList", checkedGoodsList);
		data.put("goodsTotalPrice", goodsTotalPrice);
		data.put("orderTotalPrice", orderTotalPrice);
		data.put("actualPrice", actualPrice);
		result.setData(data);
		return result;
	}

}
