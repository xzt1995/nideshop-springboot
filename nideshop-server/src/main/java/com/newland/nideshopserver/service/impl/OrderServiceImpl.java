package com.newland.nideshopserver.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

import com.newland.nideshopserver.model.*;
import com.newland.nideshopserver.model.dto.Result;
import com.newland.nideshopserver.model.dto.ResultCode;
import com.newland.nideshopserver.service.*;
import com.newland.nideshopserver.utis.Utis;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newland.nideshopserver.mapper.OrderMapper;
import com.newland.nideshopserver.model.dto.HandleOption;

import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

/**
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wangzb
 * @date: 2019年11月5日 下午4:32:00
 * @version V1.0
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private CartService cartService;

	@Autowired
	private AddressService addressService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private UserService userService;

	@Autowired
	private OrderGoodsService orderGoodsService;

	@Autowired
	private RegionService regionService;

	@Override
	public List<NideshopOrder> selectByUserId(Integer id) {
		Example example = new Example(NideshopOrder.class);
		Example.Criteria c = example.createCriteria();
		c.andEqualTo("userId",id);
		//RowBounds rowBounds = new RowBounds(0, 10);
		return orderMapper.selectByExample(example);
	}

	@Override
	public NideshopOrder findByUserIdAndOrderId(int orderId, int userId) {
		Example example = new Example(NideshopOrder.class);
		Example.Criteria c = example.createCriteria();
		c.andEqualTo("userId",userId);
		c.andEqualTo("id",orderId);
		return orderMapper.selectOneByExample(example);
	}

	@Override
	public String getOrderStatusText(Integer id) {
		NideshopOrder order = orderMapper.selectByPrimaryKey(id);
		String statusText="未付款";
		if(order.getOrderStatus()==null&&order.getOrderStatus()==0) {
			 statusText="未付款";
		}
		return statusText;
	}

	@Override
	public HandleOption getOrderHandleOption(Integer id) {

		HandleOption handleOption = new HandleOption();
		NideshopOrder orderInfo = orderMapper.selectByPrimaryKey(id);
		// 订单流程：下单成功－》支付订单－》发货－》收货－》评论
	    // 订单相关状态字段设计，采用单个字段表示全部的订单状态
	    // 1xx表示订单取消和删除等状态 0订单创建成功等待付款，101订单已取消，102订单已删除
	    // 2xx表示订单支付状态,201订单已付款，等待发货
	    // 3xx表示订单物流相关状态,300订单已发货，301用户确认收货
	    // 4xx表示订单退换货相关的状态,401没有发货，退款402,已收货，退款退货
	    // 如果订单已经取消或是已完成，则可删除和再次购买
		if (orderInfo.getOrderStatus() == 101) {
		      handleOption.setDelete(true);
		      handleOption.setBuy(true);
		    }

		    // 如果订单没有被取消，且没有支付，则可支付，可取消
		    if (orderInfo.getOrderStatus()== 0) {
		      handleOption.setCancel(true);
		      handleOption.setPay(true);
		    }

		    // 如果订单已付款，没有发货，则可退款操作
		    if (orderInfo.getOrderStatus() == 201) {
		      handleOption.setReturn0(true);
		    }

		    // 如果订单已经发货，没有收货，则可收货操作和退款、退货操作
		    if (orderInfo.getOrderStatus()== 300) {
		      handleOption.setCancel(true);
		      handleOption.setPay(true);
		      handleOption.setReturn0(true);
		    }

		    // 如果订单已经支付，且已经收货，则可完成交易、评论和再次购买
		    if (orderInfo.getOrderStatus() == 301) {
		      handleOption.setDelete(true);
		      handleOption.setComment(true);
		      handleOption.setBuy(true);
		    }
		    return handleOption;
	}

	@Override
	public Integer add(NideshopOrder order) {
		Integer orderId = orderMapper.insert(order);
		return orderId;
	}

	@Transactional
	@Override
	public Result submit(int addressId, int couponId, String postscript, int userId) {

		// 获取收货地址信息和计算运费
		NideshopAddress address = addressService.findByAddressId(addressId);
		if (address == null) {
			return Result.build(ResultCode.NO_ADDRESS.val(), ResultCode.NO_ADDRESS.msg(), null);
		}
		// 获取要购买的商品
		List<NideshopCart> checkedCart = cartService.findCheckedCart(userId, "1", 1);
		if (checkedCart == null) {
			return Result.build(ResultCode.NO_GOODS.val(), ResultCode.NO_GOODS.msg(), null);
		}
		// 统计商品总价
		BigDecimal freightPrice = new BigDecimal(0);
		BigDecimal goodsTotalPrice = new BigDecimal(0);
		for (NideshopCart nideshopCart : checkedCart) {
			goodsTotalPrice = goodsTotalPrice.add(nideshopCart.getRetailPrice().multiply(new BigDecimal(nideshopCart.getNumber())));
		}

		// TODO 获取订单使用的优惠券 (功能未实现)
		BigDecimal couponPrice = new BigDecimal(0);
		// 订单价格计算
		BigDecimal orderTotalPrice = goodsTotalPrice.add(freightPrice).subtract(couponPrice); // 订单的总价
		BigDecimal actualPrice = orderTotalPrice.subtract(couponPrice); // 减去其它支付的金额后，要实际支付的金额

		NideshopOrder order = new NideshopOrder();
		order.setOrderSn(Utis.generateOrderNumber(new Date()));
		order.setUserId(userId);
		// 收货地址和运费
		order.setConsignee(address.getName());
		order.setMobile(address.getMobile());
		order.setCountry(address.getCountryId());
		order.setProvince(address.getProvinceId());
		order.setCity(address.getCityId());
		order.setDistrict(address.getDistrictId());
		order.setAddress(address.getAddress());
		// TODO: 2019/11/18 运费功能未实现
		order.setFreightPrice(0);
		//留言
		if (postscript==null){
			order.setPostscript("");
		}else {
			order.setPostscript(postscript);
		}

		// 使用的优惠券
		order.setCouponId(0);
		order.setCouponPrice(couponPrice);
		Date date = new Date();
		order.setAddTime(date.getTime()/1000);
		order.setConfirmTime(0L);
		order.setPayTime(0L);
		order.setGoodsPrice(goodsTotalPrice);
		order.setOrderPrice(orderTotalPrice);
		order.setActualPrice(actualPrice);
		order.setOrderStatus(0);
		order.setShippingStatus(0);
		order.setShippingFee(new BigDecimal(0.00));
		order.setPayStatus(0);
		order.setPayName("");
		order.setPayId(0);
		order.setIntegral(0);
		order.setIntegralMoney(new BigDecimal(0.00));
		order.setParentId(0);
		order.setCallbackStatus("true");
		Integer orderId = orderService.add(order);
		if (!Objects.nonNull(orderId)){
			return Result.build(ResultCode.INSERT_ORDER_ERROR.val(), ResultCode.INSERT_ORDER_ERROR.msg(), null);
		}
		List<NideshopOrderGoods> orderGoodsData = new ArrayList<>();
		// 统计商品总价
		for (NideshopCart goodsItem : checkedCart) {
			NideshopOrderGoods good = new NideshopOrderGoods();
			good.setOrderId(order.getId());
			good.setGoodsId(goodsItem.getGoodsId());
			good.setGoodsSn(goodsItem.getGoodsSn());
			good.setProductId(goodsItem.getProductId());
			good.setGoodsName(goodsItem.getGoodsName());
			good.setListPicUrl(goodsItem.getListPicUrl());
			good.setMarketPrice(goodsItem.getMarketPrice());
			good.setRetailPrice(goodsItem.getRetailPrice());
			good.setNumber(goodsItem.getNumber());
			good.setGoodsSpecifitionNameValue(goodsItem.getGoodsSpecifitionNameValue());
			good.setGoodsSpecifitionIds(goodsItem.getGoodsSpecifitionIds());
			good.setIsReal(0);
			orderGoodsData.add(good);
		}
		Integer addManyId = orderGoodsService.addMany(orderGoodsData);
		if (!Objects.nonNull(addManyId)){
			return Result.build(ResultCode.INSERT_ORDER_ERROR.val(), ResultCode.INSERT_ORDER_ERROR.msg(), null);
		}
		//删除购物车
		Integer deleteId = cartService.deleteCheckedCart(userId, "1", 1);
		if (!Objects.nonNull(deleteId)){
			return Result.build(ResultCode.INSERT_ORDER_ERROR.val(), ResultCode.INSERT_ORDER_ERROR.msg(), null);
		}

		HashMap<String, Object> map = new HashMap<>();
		map.put("orderInfo",order);
		return Result.build(ResultCode.SUCCESS.val(),ResultCode.SUCCESS.msg(),map);
	}

	@Override
	public Result orderDetail(int orderId, int userId) {
		NideshopOrder order = orderService.findByUserIdAndOrderId(orderId, userId);
		if (!Objects.nonNull(order) && order.getId()==null){
			return Result.build(ResultCode.NO_ORDER.val(),ResultCode.NO_ORDER.msg(),null);
		}
		String provinceName = regionService.getRegionName(order.getProvince());
		String cityName = regionService.getRegionName(order.getCity());
		String districtName = regionService.getRegionName(order.getDistrict());
		String fullRegion = provinceName+cityName+districtName;

		List<NideshopOrderGoods> orderGoods = orderGoodsService.selectByOrderId(orderId);
		// 订单状态的处理
		String statusText = orderService.getOrderStatusText(orderId);//未付款
		order.setStatusText(statusText);
		String addTime = Utis.timeFormat(order.getAddTime());
		HandleOption handleOption = orderService.getOrderHandleOption(order.getId());
		order.setHandleOption(handleOption);
		HashMap<String, Object> map = new HashMap<>();
		map.put("orderInfo",order);
		map.put("orderGoods",orderGoods);
		map.put("handleOption",handleOption);
		Result result = new Result();
		result.setData(map);
		return result;
	}


}
