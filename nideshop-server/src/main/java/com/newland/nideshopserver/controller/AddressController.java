package com.newland.nideshopserver.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newland.nideshopserver.model.NideshopAddress;
import com.newland.nideshopserver.model.dto.Result;
import com.newland.nideshopserver.service.AddressService;
import com.newland.nideshopserver.service.RegionService;
import com.newland.nideshopserver.utis.RequestParamParseUtil;

/**
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wangzb
 * @date: 2019年11月8日 下午4:23:39
 * @version V1.0
 */
@RestController
public class AddressController {

	@Autowired
	private AddressService addressService;

	@Autowired
	private RequestParamParseUtil requestParamParseUtil;
	
	@Autowired
	private RegionService regionService;

	/**
	 * 添加或更新收货地址
	 */
	@RequestMapping("address/save")
	public Result save(HttpServletRequest request, Integer id, String name, String mobile, Integer province_id,
			Integer city_id, Integer district_id, String address, Boolean is_default) {
		Result result = new Result();
		NideshopAddress nideshopAddress = new NideshopAddress();
		// nideshopAddress.setId(id);
		nideshopAddress.setName(name);
		nideshopAddress.setMobile(mobile);
		nideshopAddress.setProvinceId(province_id);
		nideshopAddress.setCityId(city_id);
		nideshopAddress.setDistrictId(district_id);
		nideshopAddress.setAddress(address);
		nideshopAddress.setIsDefault(is_default == true ? 1 : 0);

		Integer userId = requestParamParseUtil.getUserId(request);
		if (id == null) {
			addressService.add(nideshopAddress);
		} else {
			addressService.updateByIdAndUser(nideshopAddress, id, userId);
		}

		// 如果设置为默认，则取消其它的默认
		if (is_default == true) {
			addressService.resetOtherDefault(id, userId);
		}

		NideshopAddress addressInfo = addressService.findAddress(id, null);
		result.setData(addressInfo);
		return result;

	}
	
	@RequestMapping("address/list")
	public Result list(HttpServletRequest request) {
		Integer userId = requestParamParseUtil.getUserId(request);
		
		List<NideshopAddress> addressList=addressService.selectByUserId(userId);
		
		for(int i=0;i<addressList.size();i++) {
			NideshopAddress nideshopAddress = addressList.get(i);
			nideshopAddress.setProviceName(regionService.getRegionName(nideshopAddress.getProvinceId()));
			nideshopAddress.setCityName(regionService.getRegionName(nideshopAddress.getCityId()));
			nideshopAddress.setDistrictName(regionService.getRegionName(nideshopAddress.getDistrictId()));
			nideshopAddress.setFullRegion(nideshopAddress.getProviceName() + nideshopAddress.getCityName() + nideshopAddress.getDistrictName());
		}
		
		Result result = new Result();
		result.setData(addressList);
		return result;
	}
}
