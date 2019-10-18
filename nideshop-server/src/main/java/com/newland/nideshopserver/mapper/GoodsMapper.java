package com.newland.nideshopserver.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.newland.nideshopserver.config.MyMapper;
import com.newland.nideshopserver.model.NideshopGoods;
import com.newland.nideshopserver.model.NideshopGoodsSpecification;
import com.newland.nideshopserver.model.dto.Attribute;

/**
 * @author xzt
 * @create 2019-10-11 10:47
 */
@Repository
public interface GoodsMapper extends MyMapper<NideshopGoods> {
    @Select("SELECT COUNT(`id`) AS think_count FROM `nideshop_goods` WHERE ( `is_delete` = 0 ) AND ( `is_on_sale` = 1 ) LIMIT 1")
    int goodsCount();
    /**
	 * @param id
	 * @return
	 */
    @Select("SELECT A.value,B.name FROM NIDESHOP_GOODS_ATTRIBUTE A JOIN NIDESHOP_ATTRIBUTE B ON A.attribute_id=B.id WHERE A.goods_id=#{id}")
	List<Attribute> getAttributes(Integer id);
	/**
	 * @param id
	 * @return
	 */
    @Select("SELECT gs.*,s.name FROM nideshop_goods_specification gs INNER JOIN nideshop_specification s ON gs.specification_id=s.id WHERE goods_id=#{goodsId}")
	List<NideshopGoodsSpecification> getSpecificationList(Integer goodsId);
}
