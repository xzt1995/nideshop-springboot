
package com.newland.nideshopserver.service.impl;

import java.util.Arrays;
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
 * @Description: 购物车
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
		PageInfo<NideshopCart> page = PageHelper.startPage(0, 1)
				.doSelectPageInfo(() -> cartMapper.selectByExample(example));
		List<NideshopCart> list = page.getList();
		return list.size() > 0 ? list.get(0) : null;
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
		cartMapper.incrementNumber(goodsId, productId, id, number);
	}

	@Override
	public NideshopCart getCartById(Integer id) {

		return cartMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateNumber(Integer id, Integer number) {
		cartMapper.updateNumber(id,number);
	}

	@Override
	public void update(NideshopCart cartData) {
		cartMapper.updateByPrimaryKey(cartData);
	}

	@Override
	public void deleteById(Integer id) {
		cartMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void updateChecked(String[] productIds, Integer isChecked) {
		NideshopCart cart = new NideshopCart();
		cart.setChecked(isChecked);
		Example example = new Example(NideshopCart.class);
		Criteria criteria = example.createCriteria();
		criteria.andIn("productId", Arrays.asList(productIds));
		cartMapper.updateByExampleSelective(cart, example);
	}

	@Override
	public void deleteProductIdIn(String[] productId) {
		Example example = new  Example(NideshopCart.class);
		Criteria criteria = example.createCriteria();
		criteria.andIn("productId", Arrays.asList(productId));
		cartMapper.deleteByExample(example);
	}
}
