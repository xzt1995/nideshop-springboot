/**  
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangzb   
 * @date:   2019年10月18日 下午3:56:01   
 * @version V1.0 
 */
package com.newland.nideshopserver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newland.nideshopserver.mapper.CartMapper;
import com.newland.nideshopserver.model.NideshopCart;
import com.newland.nideshopserver.service.CartService;

import tk.mybatis.mapper.entity.Example;

/**  
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangzb   
 * @date:   2019年10月18日 下午3:56:01   
 * @version V1.0 
 */
@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartMapper cartMapper;

	@Override
	public List<NideshopCart> cartList(Integer userId, String sessionId) {
		NideshopCart cart =new NideshopCart();
		cart.setUserId(userId);
		cart.setSessionId(sessionId);
		 		 
		return cartMapper.select(cart);
	}
}
