package com.newland.nideshopserver.service;

import com.newland.nideshopserver.model.dto.CategoryList;

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

}
