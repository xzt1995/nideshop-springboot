/**
 * @Description:    TODO(用一句话描述该文件做什么)
 * @author: wangzb
 * @date:   2019年10月17日 下午2:24:38
 * @version V1.0
 */
package com.newland.nideshopserver.service;

import com.newland.nideshopserver.model.NideshopUser;

/**
 * @Description:    TODO(用一句话描述该文件做什么)
 * @author: wangzb
 * @date:   2019年10月17日 下午2:24:38
 * @version V1.0
 */
public interface UserService {

	/**
	 * @param token
	 * @return
	 */
	NideshopUser findByToken(String token);

}
