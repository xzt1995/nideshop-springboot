package com.newland.nideshopserver.controller.index;

import com.newland.nideshopserver.model.*;
import com.newland.nideshopserver.model.dto.CategoryList;
import com.newland.nideshopserver.model.dto.Result;
import com.newland.nideshopserver.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xzt
 * @CREATE2019-10-11 12:11
 */
@RestController
public class IndexController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private AdService adService;
    @Autowired
    private ChannelService channelService;
    @Autowired
    private TopicService topicService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private CategoryService categoryService;


    /**
     * 显示首页数据
     * @return
     */
    @RequestMapping("/index/index")
    public Result index(){
        Result result = new Result();
        HashMap<String, Object> map = new HashMap<>();
        List<NideshopGoods> newGoods = goodsService.listNewGoods();
        List<NideshopGoods> hotGoods = goodsService.listHotGoods();
        List<NideshopAd> banner = adService.selectByPositionId(1);
        List<NideshopChannel> channel = channelService.selectAllOrder();
        List<NideshopTopic> topicList = topicService.listAllLimit3();
        List<NideshopBrand> brandList = brandService.list();
        List<CategoryList> categoryList = categoryService.categoryList();
        map.put("newGoods",newGoods);
        map.put("hotGoods",hotGoods);
        map.put("banner",banner);
        map.put("channel",channel);
        map.put("topicList",topicList);
        map.put("brandList",brandList);
        map.put("categoryList",categoryList);
        result.setData(map);
        return result;
    }


}
