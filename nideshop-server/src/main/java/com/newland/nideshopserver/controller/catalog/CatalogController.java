package com.newland.nideshopserver.controller.catalog;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newland.nideshopserver.model.NideshopCategory;
import com.newland.nideshopserver.model.dto.Result;
import com.newland.nideshopserver.service.CategoryService;

/**
 * 
 * @Description: 分类
 * @author: wangzb
 * @date: 2019年10月14日 上午11:50:35
 * @version V1.0
 */
@RestController
public class CatalogController {
	@Autowired
	private CategoryService categoryService;

	/**
	 * 分类目录全部分类数据接口
	 * 
	 * @return
	 */
	@RequestMapping("catalog/index")
	public Result index(Integer id) {

		Result result = new Result();
		NideshopCategory currentCategory = null;
		if (id != null) {
			currentCategory = categoryService.getById(id);
		}
		List<NideshopCategory> categoryList = categoryService.selectByParentId(0);
		if (categoryList.size() > 10) {
			categoryList = categoryList.subList(0, 10);
		}

		if (currentCategory == null) {
			currentCategory = categoryList.get(0);
		}

		if (currentCategory != null && currentCategory.getId() != null) {
			currentCategory.setSubCategoryList(categoryService.selectByParentId(currentCategory.getId()));
		}

		HashMap<String, Object> map = new HashMap<>();
		map.put("categoryList", categoryList);
		map.put("currentCategory", currentCategory);
		result.setData(map);
		return result;
	}

	@RequestMapping("catalog/current")
	public Result current(Integer id) {
		NideshopCategory currentCategory = null;
		if (id != null) {
			currentCategory = categoryService.getById(id);
		}
		if (currentCategory != null && currentCategory.getId() != null) {
			currentCategory.setSubCategoryList(categoryService.selectByParentId(currentCategory.getId()));
		}
		HashMap<String, Object> map = new HashMap<>();
		map.put("currentCategory", currentCategory);
		Result result = new Result();
		result.setData(map);
		return result;
	}
}
