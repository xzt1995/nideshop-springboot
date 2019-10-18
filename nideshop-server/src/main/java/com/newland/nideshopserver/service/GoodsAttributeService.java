/**  
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangzb   
 * @date:   2019年10月16日 上午11:23:15   
 * @version V1.0 
 */
package com.newland.nideshopserver.service;

import java.util.List;

import com.newland.nideshopserver.model.dto.Attribute;

/**  
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangzb   
 * @date:   2019年10月16日 上午11:23:15   
 * @version V1.0 
 */
public interface GoodsAttributeService {

	/**
	 * @param id
	 * @return
	 */
	List<Attribute> getAttributes(Integer id);

}
