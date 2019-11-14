package com.newland.nideshopserver.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newland.nideshopserver.mapper.OrderMapper;
import com.newland.nideshopserver.model.NideshopOrder;
import com.newland.nideshopserver.model.dto.HandleOption;
import com.newland.nideshopserver.service.OrderService;

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

	@Override
	public List<NideshopOrder> selectByUserId(Integer id) {
		Example example = new Example(NideshopOrder.class);
		RowBounds rowBounds = new RowBounds(0, 10);

		return orderMapper.selectByExampleAndRowBounds(example, rowBounds);
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

}
