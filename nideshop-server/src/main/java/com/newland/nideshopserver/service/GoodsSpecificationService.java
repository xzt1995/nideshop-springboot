package com.newland.nideshopserver.service;

import java.util.List;

import tk.mybatis.mapper.entity.Example;

/**  
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangzb   
 * @date:   2019年10月23日 下午4:53:59   
 * @version V1.0 
 */
public interface GoodsSpecificationService {

	/**
	 * @param example
	 * @return
	 */
	List selectByExample(Example example);

}
