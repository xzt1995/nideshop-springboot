package com.newland.nideshopserver.mapper;

import org.apache.ibatis.annotations.Select;

import com.newland.nideshopserver.config.MyMapper;
import com.newland.nideshopserver.model.NideshopRegion;

/**  
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangzb   
 * @date:   2019年11月8日 上午11:03:36   
 * @version V1.0 
 */
public interface RegionMapper extends MyMapper<NideshopRegion>{

	/**
	 * @param regionId
	 * @return
	 */
	@Select("SELECT name FROM nideshop_region WHERE id=#{regionId}")
	String getRegionName(Integer regionId);

}
