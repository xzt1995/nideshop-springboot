package com.newland.nideshopserver.service.impl;

import com.newland.nideshopserver.mapper.TopicMapper;
import com.newland.nideshopserver.model.NideshopTopic;
import com.newland.nideshopserver.model.dto.CountSelect;
import com.newland.nideshopserver.service.TopicService;
import com.newland.nideshopserver.utis.Utis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author xzt
 * @CREATE2019-09-30 14:28
 */
@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicMapper topicMapper;

    @Override
    public List<NideshopTopic> listAllLimit3() {
        List<NideshopTopic> list = topicMapper.selectAll();
        list.subList(0, 3);
        return list;
    }

    /**
     * 点击topic页面先执行的方法
     * 总数据条数超过size的部分前端不显示（35条数据，size =10 ，则只显示3页）
     *
     * @return
     */
    @Override
    public CountSelect indexService(int page, int size) {

        // 查询总数据条数
        int count = topicMapper.selectCount(new NideshopTopic());
        // 总页数
        int totalPages = Utis.totalPages(count, size);
        // 查询数据起始坐标
        int begin = (size * page) - size;
        List<NideshopTopic> list = topicMapper.selectTopic(begin, size);

        CountSelect countSelect = new CountSelect();
        countSelect.setCount(count);
        countSelect.setCurrentPage(page);
        countSelect.setPageSize(size);
        countSelect.setTotalPages(totalPages);
        countSelect.setData(list);

        return countSelect;
    }

    /**
     * 专题详情
     * @param id
     * @return
     */
    @Override
    public NideshopTopic detailService(int id) {
        NideshopTopic nideshopTopic = topicMapper.selectByPrimaryKey(id);
        return nideshopTopic;
    }

    /**
     * 关联专题（取前四个）
     * @return
     */
    @Override
    public List<NideshopTopic> relatedTopic() {
        List<NideshopTopic> nideshopTopics = topicMapper.relatedTopic(4);
        return nideshopTopics;
    }
}
