package com.newland.nideshopserver.service;

import java.util.List;

import com.newland.nideshopserver.model.NideshopCart;
import com.newland.nideshopserver.model.NideshopOrderGoods;

/**
 * @Description:    TODO(用一句话描述该文件做什么)
 * @author: wangzb
 * @date:   2019年11月6日 上午10:22:54
 * @version V1.0
 */
public interface OrderGoodsService {

	/**
	 * @param id
	 * @return
	 */
	List<NideshopOrderGoods> selectByOrderId(Integer id);

    Integer addMany(List<NideshopOrderGoods> orderGoodsData);

}
