/**  
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangzb   
 * @date:   2019年10月18日 下午3:55:37   
 * @version V1.0 
 */
package com.newland.nideshopserver.service;

import java.util.List;

import com.newland.nideshopserver.model.NideshopCart;

/**  
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangzb   
 * @date:   2019年10月18日 下午3:55:37   
 * @version V1.0 
 */
public interface CartService {

	/**
	 * @param userId
	 * @param i
	 * @return
	 */
	List<NideshopCart> cartList(Integer userId, String sessionId);

}
