package com.newland.nideshopserver.controller.comment;

import com.newland.nideshopserver.model.dto.CountSelect;
import com.newland.nideshopserver.model.dto.Result;
import com.newland.nideshopserver.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Year;
import java.util.HashMap;

/**
 * @author xzt
 * @CREATE2019-10-15 10:13
 */
@RestController
public class CommentController {


    @Autowired
    private CommentService commentService;

    /**
     * 评论
     * @param valueId
     * @param typeId
     * @param showType
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/comment/list")
    public Result listAction(int valueId , int typeId ,int size , Integer showType , Integer page)throws Exception{
        CountSelect countSelect = commentService.listService(typeId, valueId, size,showType,page);
        Result result = new Result();
        result.setData(countSelect);
        return result;
    }

    /**
     * 评论数量计算
     * @param typeId
     * @param valueId
     * @return
     */
    @RequestMapping("/comment/count")
    public Result countAction(int typeId, int valueId){
        int allCount = commentService.allCount(typeId, valueId);
        int hasPicCount = commentService.picCount(typeId, valueId);
        Result result = new Result();
        HashMap<String, Object> map = new HashMap<>();
        map.put("allCount",allCount);
        map.put("hasPicCount",hasPicCount);
        result.setData(map);
        return result;
    }

}
