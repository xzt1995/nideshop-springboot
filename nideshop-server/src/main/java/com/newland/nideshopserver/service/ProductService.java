package com.newland.nideshopserver.service;

import com.newland.nideshopserver.model.NideshopProduct;

/**  
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangzb   
 * @date:   2019年10月23日 下午3:49:21   
 * @version V1.0 
 */
public interface ProductService {

	NideshopProduct getProductInfo(Integer goodsId,Integer productId);
}
