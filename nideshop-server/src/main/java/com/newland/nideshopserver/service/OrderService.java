package com.newland.nideshopserver.service;

import java.util.List;

import com.newland.nideshopserver.model.NideshopOrder;
import com.newland.nideshopserver.model.dto.HandleOption;

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
	
}
