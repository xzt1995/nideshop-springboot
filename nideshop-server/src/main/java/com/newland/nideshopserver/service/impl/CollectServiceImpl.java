/**  
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangzb   
 * @date:   2019年10月17日 下午3:04:52   
 * @version V1.0 
 */
package com.newland.nideshopserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newland.nideshopserver.mapper.CollectMapper;
import com.newland.nideshopserver.model.NideshopCollect;
import com.newland.nideshopserver.service.CollectService;

/**  
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangzb   
 * @date:   2019年10月17日 下午3:04:52   
 * @version V1.0 
 */
@Service
public class CollectServiceImpl implements CollectService {

	@Autowired
	private CollectMapper collectMapper;
	@Override
	public int isUserHasCollect(Integer userId,int typeId, Integer valueId) {
		NideshopCollect collect=new NideshopCollect();
		collect.setUserId(userId);
		collect.setTypeId(typeId);
		collect.setValueId(valueId);
		return collectMapper.selectCount(collect);
	}

}
