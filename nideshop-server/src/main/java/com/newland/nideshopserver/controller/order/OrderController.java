package com.newland.nideshopserver.controller.order;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.newland.nideshopserver.model.*;
import com.newland.nideshopserver.model.dto.ResultCode;
import com.newland.nideshopserver.service.*;
import com.newland.nideshopserver.utis.Utis;
import com.sun.xml.internal.bind.v2.TODO;
import org.apache.ibatis.annotations.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newland.nideshopserver.model.dto.HandleOption;
import com.newland.nideshopserver.model.dto.Result;

/**
 * @version V1.0
 * @Description: 订单
 * @author: wangzb
 * @date: 2019年11月5日 下午4:18:35
 */
@RestController
public class OrderController {

    @Autowired
    private CartService cartService;

    @Autowired
    private AddressService addressService;

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
                item.setNideshopOrderGoods(goodsList);
                item.setGoodsCount(0);//1
                for (int j = 0; j < goodsList.size(); j++) {
                    item.setGoodsCount(item.getGoodsCount() + goodsList.get(j).getNumber());//0+1
                }
                // 订单状态的处理
                String statusText = orderService.getOrderStatusText(item.getId());//未付款
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

    /**
     * 生成订单
     * @param addressId 地址
     * @param couponId 优惠
     * @param postscript 留言
     * @param request
     * @return
     */
    @RequestMapping("order/submit")
    public Result submit(int addressId, int couponId, String postscript ,HttpServletRequest request) {

        String token = request.getHeader("X-Nideshop-Token");
        NideshopUser user = userService.findByToken(token);
        Integer userId = user.getId();
        Result result = orderService.submit(addressId, couponId, postscript, userId);
        return result;
    }

    @RequestMapping("order/detail")
    public Result detail(int orderId,HttpServletRequest request){
        String token = request.getHeader("X-Nideshop-Token");
        NideshopUser user = userService.findByToken(token);
        Integer userId = user.getId();
        Result result = orderService.orderDetail(orderId, userId);
        return result;
    }


}
