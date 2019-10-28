/**  
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangzb   
 * @date:   2019年10月18日 下午3:53:57   
 * @version V1.0 
 */
package com.newland.nideshopserver.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.newland.nideshopserver.config.MyMapper;
import com.newland.nideshopserver.model.NideshopCart;

/**  
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangzb   
 * @date:   2019年10月18日 下午3:53:57   
 * @version V1.0 
 */
public interface CartMapper extends MyMapper<NideshopCart> {

	/**
	 * @param goodsId
	 * @param productId
	 * @return
	 */
	@Select("SELECT * FROM nideshop_cart WHERE goods_id=#{goodsId} AND product_id=#{productId} LIMIT 1")
	NideshopCart getCartInfo(@Param("goodsId")Integer goodsId, @Param("productId")Integer productId);

	/**
	 * @param productId
	 * @return
	 */
	@Select("SElECT COUNT(1) FROM nideshop_cart WHERE product_id=#{productId}")
	int productCount(Integer productId);

	/**
	 * @param goodsId
	 * @param productId
	 * @param id
	 * @param number
	 */
	@Update("UPDATE nideshop_cart SET number=number+#{number} WHERE goods_id=#{goodsId} AND product_id=#{productId} AND id=#{id}")
	void incrementNumber(@Param("goodsId")Integer goodsId, @Param("productId")Integer productId, @Param("id")Integer id, @Param("number")Integer number);

}
