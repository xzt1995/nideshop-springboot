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
import tk.mybatis.mapper.entity.Example.Criteria;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xzt @CREATE2019-10-11 14:06
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
			e.selectProperties("id", "name", "listPicUrl", "retailPrice");
			e.createCriteria().andIn("categoryId", secondCategory);
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

	@Override
	public NideshopCategory getById(Integer id) {
		NideshopCategory category = categoryMapper.selectByPrimaryKey(id);
		return category;
	}

	@Override
	public List<NideshopCategory> selectByParentId(Integer parentId) {
		Example e = new Example(NideshopCategory.class);
		e.createCriteria().andEqualTo("parentId", parentId);

		List<NideshopCategory> list = categoryMapper.selectByExample(e);

		return list;

	}

	@Override
	public List queryByExample(Example e2) {
		List list = categoryMapper.selectByExample(e2);
		return list;
	}

	@Override
	public List<Integer> selectSubCatetoryIds(Integer categoryId) {

		return categoryMapper.listSecondCategory(categoryId);
	}

	@Override
	public List<Integer> getChildCategoryId(Integer categoryId) {
		return categoryMapper.getChildCategoryId(categoryId);
	}

	@Override
	public List<Integer> getParentIdsBycategoryIds(List<Integer> categoryIds) {
		Example e2 = new Example(NideshopCategory.class);
		Criteria criteria2 = e2.selectProperties("parentId").createCriteria();
		criteria2.andIn("id", categoryIds);

		@SuppressWarnings("unchecked")
		List<NideshopCategory> ParentCategorys = categoryMapper.selectByExample(e2);
		int listSize2 = ParentCategorys.size();
		if (listSize2 > 10000) {
			listSize2 = 10000;
		}
		ArrayList<Integer> parentIds = new ArrayList<>();
		for (int i = 0; i < listSize2; i++) {
			parentIds.add(ParentCategorys.get(i).getParentId());
		}
		return parentIds;
	}

	@Override
	public List<NideshopCategory> selectByIdList(List<Integer> parentIds) {
		Example e3 = new Example(NideshopCategory.class);
		e3.setOrderByClause("sort_order");
		Criteria criteria3 = e3.selectProperties("id", "name").createCriteria();
		criteria3.andIn("id", parentIds);
		@SuppressWarnings("unchecked")
		List<NideshopCategory> parentCategory = categoryMapper.selectByExample(e3);
		return parentCategory;
	}
}
