package com.newland.nideshopserver.service;

import java.util.List;

import com.newland.nideshopserver.model.NideshopRegion;

/**  
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangzb   
 * @date:   2019年11月7日 上午11:24:01   
 * @version V1.0 
 */
public interface RegionService {

	/**
	 * @param provinceId
	 * @return
	 */
	String getRegionName(Integer provinceId);

	/**
	 * @param parentId
	 * @return
	 */
	List<NideshopRegion> getRegionList(Integer parentId);

	/**
	 * @param regionId
	 * @return
	 */
	NideshopRegion getRegionInfo(Integer regionId);

}
