package com.newland.nideshopserver.service;

import com.newland.nideshopserver.model.NideshopTopic;
import com.newland.nideshopserver.model.dto.CountSelect;

import java.util.List;

/**
 * @author xzt
 * @create 2019-09-30 14:26
 * 专题信息服务
 */
public interface TopicService {

    List<NideshopTopic> listAllLimit3();


    CountSelect indexService(int page , int size);


    NideshopTopic detailService(int id);

    List<NideshopTopic> relatedTopic();
}
