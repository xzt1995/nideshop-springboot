/**  
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangzb   
 * @date:   2019年10月16日 上午11:23:31   
 * @version V1.0 
 */
package com.newland.nideshopserver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newland.nideshopserver.mapper.GoodsMapper;
import com.newland.nideshopserver.model.dto.Attribute;
import com.newland.nideshopserver.service.GoodsAttributeService;

/**  
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangzb   
 * @date:   2019年10月16日 上午11:23:31   
 * @version V1.0 
 */
@Service
public class GoodsAttributeServiceImpl implements GoodsAttributeService{

	@Autowired
	private GoodsMapper goodesMapper;
	@Override
	public List<Attribute> getAttributes(Integer id) {
		
		return goodesMapper.getAttributes(id);
	}

}
