package com.newland.nideshopserver.service;

import java.util.List;

import com.newland.nideshopserver.model.NideshopGoods;
import com.newland.nideshopserver.model.NideshopProduct;
import com.newland.nideshopserver.model.dto.Specification;

import tk.mybatis.mapper.entity.Example;

/**
 * @author xzt
 * @create 2019-10-11 11:35
 */
public interface GoodsService {
    List<NideshopGoods> listNewGoods();
    List<NideshopGoods> listHotGoods();
    int goodsCount();
    /**
	 * @param e
	 */
    List<NideshopGoods> queryByExample(Example e);
    
	/**
	 * @param id
	 * @return
	 */
	NideshopGoods selectById(Integer id);
	/**
	 * @param id
	 * @return
	 */
	List<Specification> getSpecificationList(Integer id);
	/**
	 * @param id
	 */
	List<NideshopProduct> getProductList(Integer goodsId);
	/**
	 * @param id
	 * @return
	 */
	List<NideshopGoods> relatedGoods(Integer id);
}
