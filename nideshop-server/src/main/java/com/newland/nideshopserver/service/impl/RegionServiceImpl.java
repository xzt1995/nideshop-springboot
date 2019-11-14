package com.newland.nideshopserver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newland.nideshopserver.mapper.RegionMapper;
import com.newland.nideshopserver.model.NideshopRegion;
import com.newland.nideshopserver.service.RegionService;

/**
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wangzb
 * @date: 2019年11月7日 上午11:24:13
 * @version V1.0
 */
@Service
public class RegionServiceImpl implements RegionService {

	@Autowired
	private RegionMapper regionMapper;

	@Override
	public String getRegionName(Integer regionId) {

		return regionMapper.getRegionName(regionId);
	}

	@Override
	public List<NideshopRegion> getRegionList(Integer parentId) {
		NideshopRegion record = new NideshopRegion();
		record.setParentId(parentId);
		return regionMapper.select(record);
	}

	@Override
	public NideshopRegion getRegionInfo(Integer regionId) {

		return regionMapper.selectByPrimaryKey(regionId);
	}

}
