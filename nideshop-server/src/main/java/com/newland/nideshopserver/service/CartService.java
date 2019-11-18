package com.newland.nideshopserver.service;

import java.util.List;

import com.newland.nideshopserver.model.NideshopCart;

/**
 * @Description:    TODO(用一句话描述该文件做什么)
 * @author: wangzb
 * @date:   2019年10月18日 下午3:55:37
 * @version V1.0
 */
public interface CartService {

	/**
	 * @param userId
	 * @param i
	 * @return
	 */
	List<NideshopCart> cartList(Integer userId, String sessionId);

	/**
	 * @param goodsId
	 * @param productId
	 * @param productId2
	 * @return
	 */
	NideshopCart getCartInfo(Integer goodsId, Integer productId, Integer productId2);

	/**
	 * 根据productId查询，若不存在则插入
	 * @param nideshopCart
	 * @param productId
	 */
	void thenAdd(NideshopCart nideshopCart, Integer productId);

	/**
	 * @param goodsId
	 * @param productId
	 * @param id
	 * @param number
	 */
	void incrementNumber(Integer goodsId, Integer productId, Integer id, Integer number);

	/**
	 * @param id
	 * @return
	 */
	NideshopCart getCartById(Integer id);

	/**
	 * @param id
	 * @param number
	 */
	void updateNumber(Integer id, Integer number);

	/**
	 * @param cartData
	 */
	void update(NideshopCart cartData);

	/**
	 * @param id
	 */
	void deleteById(Integer id);

	/**
	 * @param productIds
	 * @param isChecked
	 */
	void updateChecked(String[] productIds, Integer isChecked);

	/**
	 * @param productId
	 */
	void deleteProductIdIn(String[] productId);

	List<NideshopCart> findCheckedCart(Integer userId, String sessionId , Integer check);

	Integer deleteCheckedCart(Integer userId, String sessionId , Integer check);
}
