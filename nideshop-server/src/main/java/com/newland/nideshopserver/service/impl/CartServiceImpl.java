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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.newland.nideshopserver.mapper.CartMapper;
import com.newland.nideshopserver.model.NideshopCart;
import com.newland.nideshopserver.service.CartService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wangzb
 * @date: 2019年10月18日 下午3:56:01
 * @version V1.0
 */
@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartMapper cartMapper;

	@Override
	public List<NideshopCart> cartList(Integer userId, String sessionId) {
		NideshopCart cart = new NideshopCart();
		cart.setUserId(userId);
		cart.setSessionId(sessionId);

		return cartMapper.select(cart);
	}

	@SuppressWarnings("unchecked")
	@Override
	public NideshopCart getCartInfo(Integer goodsId, Integer productId) {
		
		
		Example example = new Example(NideshopCart.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("goodsId", goodsId);
		criteria.andEqualTo("productId", productId);
		PageInfo<NideshopCart> page=PageHelper.startPage(0, 1).doSelectPageInfo(() ->cartMapper.selectByExample(example));
		List<NideshopCart> list = page.getList();
		return list.size()>0?list.get(0):null;
	}

	@Override
	public void thenAdd(NideshopCart nideshopCart, Integer productId) {
		int exists = cartMapper.productCount(productId);
		if (exists == 0) {
			cartMapper.insert(nideshopCart);
		}

	}

	@Override
	public void incrementNumber(Integer goodsId, Integer productId, Integer id, Integer number) {
		cartMapper.incrementNumber(goodsId,productId,id,number);
	}
}
