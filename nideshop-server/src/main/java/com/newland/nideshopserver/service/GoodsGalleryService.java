/**  
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangzb   
 * @date:   2019年10月16日 上午10:50:08   
 * @version V1.0 
 */
package com.newland.nideshopserver.service;

import java.util.List;

import com.newland.nideshopserver.model.NideshopGoodsGallery;

/**  
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangzb   
 * @date:   2019年10月16日 上午10:50:08   
 * @version V1.0 
 */
public interface GoodsGalleryService {

	List<NideshopGoodsGallery> selectByGoodsId(Integer goodsId,int page,int size);
	
}
