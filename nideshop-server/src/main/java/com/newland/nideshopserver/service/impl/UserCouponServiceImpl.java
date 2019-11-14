package com.newland.nideshopserver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newland.nideshopserver.mapper.UserCouponMapper;
import com.newland.nideshopserver.model.NideshopUserCoupon;
import com.newland.nideshopserver.service.UserCouponService;

/**  
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangzb   
 * @date:   2019年11月8日 下午2:44:24   
 * @version V1.0 
 */
@Service
public class UserCouponServiceImpl implements UserCouponService{

	@Autowired
	private UserCouponMapper userCouponMapper;
	@Override
	public List<NideshopUserCoupon> selectAll() {
		
		return userCouponMapper.selectAll();
	}

}
