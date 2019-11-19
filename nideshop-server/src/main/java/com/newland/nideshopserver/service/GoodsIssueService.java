/**  
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangzb   
 * @date:   2019年10月17日 上午9:53:21   
 * @version V1.0 
 */
package com.newland.nideshopserver.service;

import java.util.List;

import com.newland.nideshopserver.model.NideshopGoodsIssue;

/**  
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangzb   
 * @date:   2019年10月17日 上午9:53:21   
 * @version V1.0 
 */
public interface GoodsIssueService {

	/**
	 * @return
	 */
	List<NideshopGoodsIssue> selectAll();

}
