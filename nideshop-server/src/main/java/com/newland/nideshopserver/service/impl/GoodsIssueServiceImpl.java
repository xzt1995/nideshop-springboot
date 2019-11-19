/**
 * @Description:    TODO(用一句话描述该文件做什么)
 * @author: wangzb
 * @date:   2019年10月17日 上午9:53:37
 * @version V1.0
 */
package com.newland.nideshopserver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newland.nideshopserver.mapper.GoodsIssueMapper;
import com.newland.nideshopserver.model.NideshopGoodsIssue;
import com.newland.nideshopserver.service.GoodsIssueService;

/**
 * @Description:    TODO(用一句话描述该文件做什么)
 * @author: wangzb
 * @date:   2019年10月17日 上午9:53:37
 * @version V1.0
 */
@Service
public class GoodsIssueServiceImpl implements GoodsIssueService {

	@Autowired
	private GoodsIssueMapper goodsIssueMapper;
	@Override
	public List<NideshopGoodsIssue> selectAll() {
		return goodsIssueMapper.selectAll();
	}

}
