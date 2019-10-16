package com.newland.nideshopserver.controller.goods;

import com.newland.nideshopserver.model.dto.Result;
import com.newland.nideshopserver.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;


/**
 * @author xzt
 * @CREATE2019-10-11 12:36
 */
@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;


    /**
     * 首页搜索框显示的宝贝总数
     * @return
     */
    @RequestMapping("/goods/count")
    public Result count(){
        Result result = new Result();
        HashMap<String, Object> map = new HashMap<>();
        int goodsCount = goodsService.goodsCount();
        map.put("goodsCount",goodsCount);
        result.setData(map);
        return result;
    }
}
