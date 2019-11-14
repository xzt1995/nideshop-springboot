package com.newland.nideshopserver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newland.nideshopserver.mapper.GoodsSpecificationMapper;
import com.newland.nideshopserver.service.GoodsSpecificationService;

import tk.mybatis.mapper.entity.Example;

/**  
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangzb   
 * @date:   2019年10月23日 下午4:54:18   
 * @version V1.0 
 */
@Service
public class GoodsSpecificationServiceImpl implements GoodsSpecificationService {

	@Autowired
	private GoodsSpecificationMapper goodsSpecificationMapper;
	@Override
	public List selectByExample(Example example) {
		return goodsSpecificationMapper.selectByExample(example);
	}

}
