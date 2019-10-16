package com.newland.nideshopserver.controller.topic;

import com.newland.nideshopserver.model.NideshopTopic;
import com.newland.nideshopserver.model.dto.CountSelect;
import com.newland.nideshopserver.model.dto.Result;
import com.newland.nideshopserver.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * @author xzt
 * @CREATE2019-10-12 14:30
 */
@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topic/list")
    public Result listAction(int page ,int size){
       page =  (page > 0 ) ?  page : 1 ;
       size =  (size > 0 ) ?  size : 10 ;
       CountSelect countSelect = topicService.indexService(page, size);
       Result result = new Result();
       result.setData(countSelect);
       return result;
    }

    @RequestMapping("/topic/detail")
    public Result detailAction(int id){
        NideshopTopic topicDetail = topicService.detailService(id);
        Result result = new Result();
        result.setData(topicDetail);
        return result;
    }

    @RequestMapping("/topic/related")
    public Result relatedAction(int id){
        List<NideshopTopic> list = topicService.relatedTopic();
        Result result = new Result();
        result.setData(list);
        return result;
    }
}
