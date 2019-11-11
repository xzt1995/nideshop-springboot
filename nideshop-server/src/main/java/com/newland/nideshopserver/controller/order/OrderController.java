package com.newland.nideshopserver.controller.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newland.nideshopserver.model.NideshopOrder;
import com.newland.nideshopserver.model.NideshopOrderGoods;
import com.newland.nideshopserver.model.NideshopUser;
import com.newland.nideshopserver.model.dto.HandleOption;
import com.newland.nideshopserver.model.dto.Result;
import com.newland.nideshopserver.service.OrderGoodsService;
import com.newland.nideshopserver.service.OrderService;
import com.newland.nideshopserver.service.UserService;

/**
 * @Description: 订单
 * @author: wangzb
 * @date: 2019年11月5日 下午4:18:35
 * @version V1.0
 */
@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;

	@Autowired
	private UserService userService;

	@Autowired
	private OrderGoodsService orderGoodsService;

	@RequestMapping("order/list")
	public Result list(HttpServletRequest request) {
		Result result = new Result();
		String token = request.getHeader("X-Nideshop-Token");
		NideshopUser user = userService.findByToken(token);

		List<NideshopOrder> orderList = orderService.selectByUserId(user.getId());
		List<NideshopOrder> newOrderList = new ArrayList<NideshopOrder>();
		if (orderList != null && orderList.size() > 0) {
			for (int i = 0; i < orderList.size(); i++) {
				// 订单的商品
				NideshopOrder item = orderList.get(i);
				List<NideshopOrderGoods> goodsList = orderGoodsService.selectByOrderId(item.getId());
				item.setGoodsCount(0);
				for (int j = 0; j < goodsList.size(); j++) {
					item.setGoodsCount(item.getGoodsCount() + goodsList.get(j).getNumber());
				}
				// 订单状态的处理
				String statusText = orderService.getOrderStatusText(item.getId());
				item.setStatusText(statusText);

				// 可操作的选项
				HandleOption handleOption = orderService.getOrderHandleOption(item.getId());
				item.setHandleOption(handleOption);

				newOrderList.add(item);

			}

		}
		HashMap<String, Object> map = new HashMap<>();
		map.put("data", newOrderList);

		result.setData(map);
		return result;
	}
	
}
