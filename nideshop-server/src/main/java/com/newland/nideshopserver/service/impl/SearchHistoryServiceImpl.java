/**
 * @Description:    TODO(用一句话描述该文件做什么)
 * @author: wangzb
 * @date:   2019年10月15日 上午10:51:07
 * @version V1.0
 */
package com.newland.nideshopserver.service.impl;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newland.nideshopserver.mapper.SearchHistoryMapper;
import com.newland.nideshopserver.model.NideshopSearchHistory;
import com.newland.nideshopserver.service.SearchHistoryService;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:    TODO(用一句话描述该文件做什么)
 * @author: wangzb
 * @date:   2019年10月15日 上午10:51:07
 * @version V1.0
 */
@Service
public class SearchHistoryServiceImpl implements SearchHistoryService {

	@Autowired
	private SearchHistoryMapper searchHistoryMapper;
	@Override
	public void add(NideshopSearchHistory history) {
		searchHistoryMapper.insert(history);
	}

	@Override
	public List<NideshopSearchHistory> search(int userId) {
		Example e = new Example(NideshopSearchHistory.class);
		e.selectProperties("keyword");
		e.setDistinct(true);
		Example.Criteria c = e.createCriteria();
		c.andEqualTo("userId",userId);
		PageInfo<NideshopSearchHistory> page = PageHelper.startPage(0, 10).doSelectPageInfo(() -> searchHistoryMapper.selectByExample(e));
		List<NideshopSearchHistory> historyKeywordList = new ArrayList<>();
		historyKeywordList = page.getList();
		return historyKeywordList;
	}
}
