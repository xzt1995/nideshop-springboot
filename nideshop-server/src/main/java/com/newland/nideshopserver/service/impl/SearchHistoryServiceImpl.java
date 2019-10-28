/**  
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangzb   
 * @date:   2019年10月15日 上午10:51:07   
 * @version V1.0 
 */
package com.newland.nideshopserver.service.impl;

import org.springframework.stereotype.Service;

import com.newland.nideshopserver.mapper.SearchHistoryMapper;
import com.newland.nideshopserver.model.NideshopSearchHistory;
import com.newland.nideshopserver.service.SearchHistoryService;

/**  
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangzb   
 * @date:   2019年10月15日 上午10:51:07   
 * @version V1.0 
 */
@Service
public class SearchHistoryServiceImpl implements SearchHistoryService {

	private SearchHistoryMapper searchHistoryMapper;
	@Override
	public void add(NideshopSearchHistory history) {
		searchHistoryMapper.insert(history);
	}

}
