package com.newland.nideshopserver.controller.region;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newland.nideshopserver.model.NideshopRegion;
import com.newland.nideshopserver.model.dto.Result;
import com.newland.nideshopserver.service.RegionService;

/**
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wangzb
 * @date: 2019年11月8日 下午4:13:13
 * @version V1.0
 */
@RestController
public class RegionController {

	@Autowired
	private RegionService regionService;

	@RequestMapping("region/list")
	public Result list(Integer parentId) {

		Result result = new Result();
		List<NideshopRegion> regionList = regionService.getRegionList(parentId);

		result.setData(regionList);
		return result;
	}
	@RequestMapping("region/info")
	public Result info(Integer regionId) {
		Result result = new Result();
		NideshopRegion region=regionService.getRegionInfo(regionId);
		result.setData(region);
		return result;
	}
}
