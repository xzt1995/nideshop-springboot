package com.newland.nideshopserver.controller.collect;

import com.newland.nideshopserver.model.dto.CountSelect;
import com.newland.nideshopserver.model.dto.Result;
import com.newland.nideshopserver.service.CollectService;
import com.newland.nideshopserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author xzt
 * @CREATE2019-11-05 11:04
 * 我的收藏页面
 */
@RestController
public class CollectController {

    @Autowired
    private CollectService collectService;

    @Autowired
    private UserService userService;


    /**
     * 商品收藏
     * @param typeId
     * @return
     */
    @RequestMapping("/collect/list")
    public Result listAction(int typeId,HttpServletRequest request){
        String token = request.getHeader("X-Nideshop-Token");
        Integer userId = userService.findByToken(token).getId();
        CountSelect countSelect = collectService.listCount(typeId, userId);
        Result result = new Result();
        result.setData(countSelect);
        return result;
    }

    /**
     * 添加或删除收藏
     */
    @RequestMapping("/collect/addordelete")
    public Result addOrdeleteAction(int typeId , int valueId, HttpServletRequest request){
        String token = request.getHeader("X-Nideshop-Token");
        Integer userId = userService.findByToken(token).getId();
        String type = collectService.addordelete(typeId, valueId, userId);
        Result result = new Result();
        HashMap<String, Object> map = new HashMap<>();
        map.put("type",type);
        result.setData(map);
        return result;
    }

}
