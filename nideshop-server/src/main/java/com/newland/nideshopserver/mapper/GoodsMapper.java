package com.newland.nideshopserver.mapper;

import com.newland.nideshopserver.config.MyMapper;
import com.newland.nideshopserver.model.NideshopGoods;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xzt
 * @create 2019-10-11 10:47
 */
@Repository
public interface GoodsMapper extends MyMapper<NideshopGoods> {
    @Select("SELECT COUNT(`id`) AS think_count FROM `nideshop_goods` WHERE ( `is_delete` = 0 ) AND ( `is_on_sale` = 1 ) LIMIT 1")
    int goodsCount();
}
