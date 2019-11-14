package com.newland.nideshopserver.service;

import java.util.ArrayList;
import java.util.Map;

/**  
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangzb   
 * @date:   2019年10月29日 下午4:10:08   
 * @version V1.0 
 */
public interface SpecificationService {

	/**
	 * @param goodsSpecifitionIds
	 * @return
	 */
	Map<Integer, String> mapIdIn(ArrayList<Integer> goodsSpecifitionIds);

}
