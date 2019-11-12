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
	/**
	 * @param categoryId
	 * @return
	 */
    @Select("SELECT `id` FROM `nideshop_category` WHERE ( `parent_id` = #{categoryId} ) LIMIT 10000;")
	List<Integer> getChildCategoryId(Integer categoryId);
}
