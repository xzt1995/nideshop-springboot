package com.newland.nideshopserver.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newland.nideshopserver.mapper.GoodsMapper;
import com.newland.nideshopserver.mapper.ProductMapper;
import com.newland.nideshopserver.model.NideshopGoods;
import com.newland.nideshopserver.model.NideshopGoodsSpecification;
import com.newland.nideshopserver.model.NideshopProduct;
import com.newland.nideshopserver.model.dto.Specification;
import com.newland.nideshopserver.service.GoodsService;

import tk.mybatis.mapper.entity.Example;

/**
 * @author xzt @CREATE2019-10-11 11:36
 */
@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;

	@Autowired
	private ProductMapper productMapper;

	@Override
	public List<NideshopGoods> listNewGoods() {
		NideshopGoods g = new NideshopGoods();
		g.setIsNew(1);
		List<NideshopGoods> list = goodsMapper.select(g);
		return list;
	}

	@Override
	public List<NideshopGoods> listHotGoods() {
		NideshopGoods g = new NideshopGoods();
		g.setIsHot(1);
		List<NideshopGoods> list = goodsMapper.select(g);
		return list;
	}

	@Override
	public int goodsCount() {
		int count = goodsMapper.goodsCount();
		return count;
	}

	@Override
	public List queryByExample(Example e) {
		List list = goodsMapper.selectByExample(e);
		return list;
	}

	@Override
	public NideshopGoods selectById(Integer id) {

		return goodsMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Specification> getSpecificationList(Integer id) {
		List<NideshopGoodsSpecification> specificationRes = goodsMapper.getSpecificationList(id);
		HashMap<Integer, Object> hasSpecificationList = new HashMap<>();

		List<Specification> specificationList = new ArrayList<>();

		for (int i = 0; i < specificationRes.size(); i++) {
			NideshopGoodsSpecification specItem = specificationRes.get(i);
			if (hasSpecificationList.containsKey(specItem.getSpecificationId())) {
				Specification e = new Specification();
				e.setName(specItem.getName());
				e.setSpecificationId(specItem.getSpecificationId());
				ArrayList<NideshopGoodsSpecification> arrayList = new ArrayList<>();
				arrayList.add(specItem);
				e.setValueList(arrayList);
				specificationList.add(e);
				hasSpecificationList.put(specItem.getSpecificationId(), specItem);
			} else {
				for (int j = 0; j < specificationList.size(); j++) {
					if (specificationList.get(j).getSpecificationId() == specItem.getSpecificationId()) {
						specificationList.get(j).getValueList().add(specItem);
					}
				}
			}

		}
		return specificationList;
	}

	@Override
	public List<NideshopProduct> getProductList(Integer goodsId) {
		NideshopProduct record = new NideshopProduct();
		record.setGoodsId(goodsId);
		return productMapper.select(record);

	}

	@Override
	public List<NideshopGoods> relatedGoods(Integer id) {
		List<NideshopGoods> related=goodsMapper.relatedGoods(id);
		if(related==null||related.size()==0) {
			related=goodsMapper.selectBrotherGoods( id);
		}
		return related;
	}

	@Override
	public List<NideshopGoods> selectByParentCategoryId(Integer categoryId) {
		
		
		return goodsMapper.selectByParentCategoryId(categoryId);
	}

	@Override
	public List<NideshopGoods> selectAll() {
		return goodsMapper.selectAll();
	}

	@Override
	public String getListPicUrl(Integer goodsId) {
		return goodsMapper.getListPicUrl(goodsId);
	}
}
