package com.newland.nideshopserver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newland.nideshopserver.mapper.OrderGoodsMapper;
import com.newland.nideshopserver.model.NideshopOrderGoods;
import com.newland.nideshopserver.service.OrderGoodsService;

/**
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wangzb
 * @date: 2019年11月6日 上午10:23:18
 * @version V1.0
 */
@Service
public class OrderGoodsServiceImpl implements OrderGoodsService {

	@Autowired
	private OrderGoodsMapper orderGoodsMapper;

	@Override
	public List<NideshopOrderGoods> selectByOrderId(Integer id) {
		NideshopOrderGoods record = new NideshopOrderGoods();
		record.setOrderId(id);

		return orderGoodsMapper.select(record);
	}

}
