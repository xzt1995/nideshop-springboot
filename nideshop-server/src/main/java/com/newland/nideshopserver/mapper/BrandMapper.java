package com.newland.nideshopserver.mapper;

import com.newland.nideshopserver.config.MyMapper;
import com.newland.nideshopserver.model.NideshopBrand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author xzt
 * @create 2019-10-11 10:48
 */
@Mapper
public interface BrandMapper extends MyMapper<NideshopBrand> {

    @Select("SELECT id , name as 'name' , list_pic_url as 'listPicUrl', simple_desc as 'simpleDesc' , pic_url as 'picUrl' ,sort_order as sortOrder ,is_show as isShow ,floor_price as floorPrice, app_list_pic_url as 'appListPicUrl' ,is_new as isNew, new_pic_url as 'newPicUrl',new_sort_order  as newSortOrder FROM `nideshop_brand` WHERE ( `is_new` = 1 ) ORDER BY `new_sort_order` asc LIMIT 4")
    List<NideshopBrand> list();


}
