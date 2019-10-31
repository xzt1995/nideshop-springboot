package com.newland.nideshopserver.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newland.nideshopserver.mapper.SpecificationMapper;
import com.newland.nideshopserver.model.NideshopSpecification;
import com.newland.nideshopserver.service.SpecificationService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wangzb
 * @date: 2019年10月29日 下午4:10:23
 * @version V1.0
 */
@Service
public class SpecificationServiceImpl implements SpecificationService {

	@Autowired
	private SpecificationMapper specificationMapper;

	@Override
	public Map<Integer, String> mapIdIn(ArrayList<Integer> goodsSpecifitionIds) {
		Example example = new Example(NideshopSpecification.class);
		example.selectProperties("id", "name");
		Criteria criteria = example.createCriteria();
		criteria.andIn("id", goodsSpecifitionIds);
		List<NideshopSpecification> list = specificationMapper.selectByExample(example);
		HashMap<Integer, String> map = new HashMap<>();
		for (int i = 0; i < list.size(); i++) {
			NideshopSpecification specification = list.get(i);
			map.put(specification.getId(), specification.getName());
		}

		return map;
	}

}
