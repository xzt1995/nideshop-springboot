/**  
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangzb   
 * @date:   2019年10月17日 下午3:04:28   
 * @version V1.0 
 */
package com.newland.nideshopserver.service;

/**  
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangzb   
 * @date:   2019年10月17日 下午3:04:28   
 * @version V1.0 
 */
public interface CollectService {

	/**
	 * @param userId
	 * @param i
	 * @param id
	 * @return
	 */
	int isUserHasCollect(Integer userId, int typeId, Integer valueId);

}
