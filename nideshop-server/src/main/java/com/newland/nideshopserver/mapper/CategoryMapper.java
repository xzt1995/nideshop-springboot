package com.newland.nideshopserver.mapper;

import com.newland.nideshopserver.config.MyMapper;
import com.newland.nideshopserver.model.NideshopCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xzt
 * @create 2019-10-11 10:49
 */
@Repository
public interface CategoryMapper extends MyMapper<NideshopCategory> {

    @Select("SELECT * FROM `nideshop_category` WHERE ( `parent_id` = 0 ) AND ( `name` != '推荐' )")
    List<NideshopCategory> listParentCategory();

    @Select("SELECT `id` FROM `nideshop_category` WHERE ( `parent_id` = #{parentId} ) LIMIT 100;")
    List<Integer> listSecondCategory(int parentId);

	/**
	 * @param categoryId
	 * @return
	 */
    @Select("SELECT `id` FROM `nideshop_category` WHERE ( `parent_id` = #{categoryId} ) LIMIT 10000;")
	List<Integer> getChildCategoryId(Integer categoryId);
}
