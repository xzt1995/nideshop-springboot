/**  
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangzb   
 * @date:   2019年10月17日 下午4:19:16   
 * @version V1.0 
 */
package com.newland.nideshopserver.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.newland.nideshopserver.config.MyMapper;
import com.newland.nideshopserver.model.NideshopProduct;

/**  
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangzb   
 * @date:   2019年10月17日 下午4:19:16   
 * @version V1.0 
 */
public interface ProductMapper extends MyMapper<NideshopProduct>{

	/**
	 * @param goodsId
	 * @param productId
	 * @return
	 */
	@Select("SELECT id,goods_id as goodsId,goods_specification_ids as goodsSpecificationIds,goods_sn as goodsSn,goods_number as goodsNumber,retail_price as retailPrice FROM nideshop_product WHERE goods_id=#{goodsId} AND id=#{productId} LIMIT 1")
	NideshopProduct getProductInfo(@Param("goodsId")Integer goodsId, @Param("productId")Integer productId);

}
