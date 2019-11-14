package com.newland.nideshopserver.service;

import com.newland.nideshopserver.model.NideshopCategory;
import com.newland.nideshopserver.model.dto.CategoryList;

import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xzt
 * @create 2019-10-11 13:58
 */
public interface CategoryService {
    /**
     * 获得首页展示主要类别的前七个推荐商品信息
     * @return
     */
    List<CategoryList> categoryList();
    /**
     * 根据id查询分类
     * @param id
     * @return
     */
    NideshopCategory getById(Integer id);

	/**
	 * 根据父类id查找子分类
	 * @param parentId
	 */
	List<NideshopCategory> selectByParentId(Integer parentId);

	/**
	 * @param e2
	 * @return
	 */
	List queryByExample(Example e2);

	/**
	 * @param categoryId
	 * @return
	 */
	List<Integer> selectSubCatetoryIds(Integer categoryId);
	/**
	 * @param categoryId
	 * @return
	 */
	List<Integer> getChildCategoryId(Integer categoryId);
	/**
	 * @param categoryIds
	 * @return
	 */
	List<Integer> getParentIdsBycategoryIds(List<Integer> categoryIds);
	/**
	 * @param parentIds
	 * @return
	 */
	List<NideshopCategory> selectByIdList(List<Integer> parentIds);
}
