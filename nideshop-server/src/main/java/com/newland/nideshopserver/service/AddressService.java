package com.newland.nideshopserver.service;

import java.util.List;

import com.newland.nideshopserver.model.NideshopAddress;

/**  
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangzb   
 * @date:   2019年11月7日 上午10:32:10   
 * @version V1.0 
 */
public interface AddressService {

	/**
	 * @param userId
	 * @return
	 */
	NideshopAddress findUserDefaultAddress(Integer userId);

	NideshopAddress findAddress(Integer addressId,Integer userId);

	/**
	 * @param nideshopAddress
	 */
	void add(NideshopAddress nideshopAddress);

	/**
	 * @param nideshopAddress
	 * @param id
	 * @param userId
	 */
	void updateByIdAndUser(NideshopAddress nideshopAddress, Integer id, Integer userId);

	/**
	 * @param id
	 * @param userId
	 */
	void resetOtherDefault(Integer id, Integer userId);

	/**
	 * @param userId
	 * @return
	 */
	List<NideshopAddress> selectByUserId(Integer userId);

	/**
	 * @param id
	 * @param userId
	 */
	void delete(Integer id, Integer userId);
}
