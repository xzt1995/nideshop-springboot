package com.newland.nideshopserver.service.impl;

import com.newland.nideshopserver.mapper.CategoryMapper;
import com.newland.nideshopserver.mapper.GoodsMapper;
import com.newland.nideshopserver.model.NideshopCategory;
import com.newland.nideshopserver.model.NideshopGoods;
import com.newland.nideshopserver.model.dto.CategoryList;
import com.newland.nideshopserver.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xzt
 * @CREATE2019-10-11 14:06
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryList> categoryList() {
        // 1 获取商品的一级类别的ID集合
        List<NideshopCategory> parentCategoryList = categoryMapper.listParentCategory();
        ArrayList<CategoryList> categoryList = new ArrayList<>();
        // 2 遍历ID集合，查出所有对应该父类别的二级类别信息categoryId集合
        for (NideshopCategory categoryItem : parentCategoryList) {
            CategoryList cl = new CategoryList();
            int id = categoryItem.getId();
            List<Integer> secondCategory = categoryMapper.listSecondCategory(id);
            // 3 根据二级类别信息集合，去GOODS表中找到所有对应的信息，取前七个展示在首页
            Example e = new Example(NideshopGoods.class);
            e.selectProperties("id","name","listPicUrl","retailPrice");
            e.createCriteria().andIn("categoryId",secondCategory);
            List<NideshopGoods> good = goodsMapper.selectByExample(e);
            List<NideshopGoods> goods = good.subList(0, 7);
            // 4 封装成DTO，便于前端展示
            cl.setId(id);
            cl.setName(categoryItem.getName());
            cl.setGoodsList(goods);
            categoryList.add(cl);
        }
        return categoryList;
    }
}
