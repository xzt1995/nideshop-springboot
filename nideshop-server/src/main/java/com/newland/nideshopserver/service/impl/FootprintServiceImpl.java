/**  
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangzb   
 * @date:   2019年10月17日 下午3:21:11   
 * @version V1.0 
 */
package com.newland.nideshopserver.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newland.nideshopserver.mapper.FootprintMapper;
import com.newland.nideshopserver.model.NideshopFootprint;
import com.newland.nideshopserver.service.FootprintService;

/**  
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangzb   
 * @date:   2019年10月17日 下午3:21:11   
 * @version V1.0 
 */
@Service
public class FootprintServiceImpl implements FootprintService {

	@Autowired
	private FootprintMapper footprintMapper;

	@Override
	public void addFootprint(Integer userId, Integer goodsId) {
		NideshopFootprint footprint=new NideshopFootprint();
		footprint.setAddTime((int)(new Date().getTime()/1000));
		footprint.setGoodsId(goodsId);
		footprint.setUserId(userId);
		footprintMapper.insert(footprint);
	}
}
