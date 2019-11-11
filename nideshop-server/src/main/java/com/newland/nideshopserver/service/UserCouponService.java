package com.newland.nideshopserver.service;

import java.util.List;

import com.newland.nideshopserver.model.NideshopUserCoupon;

/**  
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangzb   
 * @date:   2019年11月8日 下午2:44:11   
 * @version V1.0 
 */
public interface UserCouponService {

	/**
	 * @return
	 */
	List<NideshopUserCoupon> selectAll();

}
