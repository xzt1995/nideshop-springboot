package com.newland.nideshopserver.controller.cart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.newland.nideshopserver.model.NideshopCart;
import com.newland.nideshopserver.model.NideshopGoods;
import com.newland.nideshopserver.model.NideshopGoodsSpecification;
import com.newland.nideshopserver.model.NideshopProduct;
import com.newland.nideshopserver.model.dto.Result;
import com.newland.nideshopserver.service.CartService;
import com.newland.nideshopserver.service.GoodsService;
import com.newland.nideshopserver.service.GoodsSpecificationService;
import com.newland.nideshopserver.service.ProductService;
import com.newland.nideshopserver.service.SpecificationService;

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

	// 获取购物车商品的总件件数
	@RequestMapping("/cart/goodscount")
	public Result goodscount(HttpSession session) {

		Map<String, Object> cart = getCart(session);
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
	public Map<String, Object> getCart(HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");

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
	public Result index(HttpSession session) {
		Result result = new Result();
		result.setData(getCart(session));
		return result;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/cart/add")
	public Result add(HttpSession session, Integer goodsId, Integer productId, Integer number) {

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

		NideshopCart cartInfo = cartService.getCartInfo(goodsId, productId);

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
			nideshopCart.setUserId((Integer) session.getAttribute("userId"));
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

		result.setData(getCart(session));
		return result;

	}

	// 更新指定的购物车信息
	@RequestMapping("cart/update")
	public Result update(HttpSession session, Integer goodsId, Integer productId, Integer id, Integer number) {
		Result result = new Result();
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
			result.setData(getCart(session));
			return result;
		}

		NideshopCart newCartInfo = cartService.getCartInfo(goodsId, productId);
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
		result.setData(getCart(session));
		return result;
	}

	@RequestMapping("cart/checked")
	public Result checked(HttpSession session, String productIds, Integer isChecked) {
		Result result = new Result();
		if (productIds == null) {
			result.setErrmsg("删除出错");
			return result;
		}

		String[] productId = productIds.split(",");
		cartService.updateChecked(productId, isChecked);

		result.setData(getCart(session));
		return result;
	}

	@RequestMapping("cart/delete")
	public Result delete(HttpSession session, String productIds) {
		Result result = new Result();
		if (productIds == null) {
			result.setErrmsg("删除出错");
			return result;
		}

		String[] productId = productIds.split(",");
		cartService.deleteProductIdIn(productId);
		
		result.setData(getCart(session));
		return result;
	}

}
