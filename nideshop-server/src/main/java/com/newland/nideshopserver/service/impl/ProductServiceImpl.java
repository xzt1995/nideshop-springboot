package com.newland.nideshopserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newland.nideshopserver.mapper.ProductMapper;
import com.newland.nideshopserver.model.NideshopProduct;
import com.newland.nideshopserver.service.ProductService;

/**
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wangzb
 * @date: 2019年10月23日 下午3:51:00
 * @version V1.0
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;

	@Override
	public NideshopProduct getProductInfo(Integer goodsId, Integer productId) {

		return productMapper.getProductInfo(goodsId,productId);
	}

}
