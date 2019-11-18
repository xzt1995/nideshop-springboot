package com.newland.nideshopserver.service;

import java.util.List;

import com.newland.nideshopserver.model.NideshopAddress;
import com.newland.nideshopserver.model.NideshopCart;
import com.newland.nideshopserver.model.NideshopOrder;
import com.newland.nideshopserver.model.dto.HandleOption;
import com.newland.nideshopserver.model.dto.Result;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:    TODO(用一句话描述该文件做什么)
 * @author: wangzb
 * @date:   2019年11月5日 下午4:30:21
 * @version V1.0
 */
public interface OrderService {

	/**
	 * @param id
	 * @return
	 */
	List<NideshopOrder> selectByUserId(Integer id);

	NideshopOrder findByUserIdAndOrderId(int orderId,int userId);

	/**
	 * @param id
	 * @return
	 */
	String getOrderStatusText(Integer id);

	/**
	 * @param id
	 * @return
	 */
	HandleOption getOrderHandleOption(Integer id);

	Integer add(  NideshopOrder order );

	Result submit(int addressId, int couponId, String postscript,int userId);

	Result orderDetail(int orderId,int userId);
}
