package com.newland.nideshopserver.service.impl;

import com.newland.nideshopserver.mapper.KeywordsMapper;
import com.newland.nideshopserver.model.NideshopKeywords;
import com.newland.nideshopserver.model.NideshopSearchHistory;
import com.newland.nideshopserver.model.dto.Result;
import com.newland.nideshopserver.model.dto.ResultCode;
import com.newland.nideshopserver.service.KeywordsService;
import com.newland.nideshopserver.service.SearchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;

/**
 * @author xzt
 * @CREATE2019-11-19 10:26
 */
@Service
public class KeywordsServiceImpl implements KeywordsService {

    @Autowired
    private KeywordsMapper keywordsMapper;

    @Autowired
    private SearchHistoryService searchHistoryService;

    @Override
    public Result index(int userId) {
        // 取出输入框默认的关键词
        Example e = new Example(NideshopKeywords.class);
        Example.Criteria c = e.createCriteria();
        c.andEqualTo("isDefault",1);
        NideshopKeywords defaultKeyword = keywordsMapper.selectOneByExample(e);
        // 取出热闹关键词
        Example e2 = new Example(NideshopKeywords.class);
        e2.selectProperties("keyword","isHot");
        e2.setDistinct(true);
        List<NideshopKeywords> hotKeywordList = keywordsMapper.selectByExample(e2);
        List<NideshopSearchHistory> historyKeywordList = searchHistoryService.search(userId);
        HashMap<String, Object> map = new HashMap<>();
        map.put("defaultKeyword",defaultKeyword);
        map.put("hotKeywordList",hotKeywordList);
        map.put("historyKeywordList",historyKeywordList);
        Result result = new Result();
        result.setData(map);
        return result;
    }
}
