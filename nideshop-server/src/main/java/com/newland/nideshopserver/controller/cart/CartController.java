/**  
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangzb   
 * @date:   2019年10月18日 下午3:57:22   
 * @version V1.0 
 */
package com.newland.nideshopserver.controller.cart;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newland.nideshopserver.model.NideshopCart;
import com.newland.nideshopserver.model.dto.Result;
import com.newland.nideshopserver.service.CartService;

/**
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wangzb
 * @date: 2019年10月18日 下午3:57:22
 * @version V1.0
 */
@RestController
public class CartController {

	@Autowired
	private CartService cartService;

	@RequestMapping("/cart/goodscount")
	public Result goodscount(HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		
		List<NideshopCart> cartList=cartService.cartList(userId,"1");
		Result result = new Result();
		int goodsCount=0;
		BigDecimal goodsAmount=new BigDecimal(0);
		int checkedGoodsCount=0;
		BigDecimal checkedGoodsAmount=new BigDecimal(0);;
		
		for(int i=0;i<cartList.size();i++) {
			NideshopCart cartItem = cartList.get(i);
			goodsCount+=cartItem.getNumber();
			goodsAmount=goodsAmount.add(cartItem.getRetailPrice().multiply(new BigDecimal( cartItem.getNumber())));
			
			if(cartItem.getChecked()!=null) {
				checkedGoodsCount+=cartItem.getNumber();
				checkedGoodsAmount=checkedGoodsAmount.add(cartItem.getRetailPrice().multiply(new BigDecimal( cartItem.getNumber())));
				
			}
		}
		return result;
	}
}
