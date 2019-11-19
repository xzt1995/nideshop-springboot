/**  
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: wangzb   
 * @date:   2019年10月16日 上午10:56:19   
 * @version V1.0 
 */
package com.newland.nideshopserver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.newland.nideshopserver.mapper.GoodsGalleryMapper;
import com.newland.nideshopserver.model.NideshopGoodsGallery;
import com.newland.nideshopserver.service.GoodsGalleryService;

import tk.mybatis.mapper.entity.Example;

/**
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wangzb
 * @date: 2019年10月16日 上午10:56:19
 * @version V1.0
 */
@Service
public class GoodsGalleryServiceImpl implements GoodsGalleryService {

	@Autowired
	private GoodsGalleryMapper goodsGalleryMapper;

	@Override
	public List<NideshopGoodsGallery> selectByGoodsId(Integer goodsId, int page, int size) {
		Example e = new Example(NideshopGoodsGallery.class);
		e.createCriteria().andEqualTo("goodsId", goodsId);

		PageInfo<NideshopGoodsGallery> pageInfo = PageHelper.startPage(page, size)
				.doSelectPageInfo(() -> goodsGalleryMapper.selectByExample(e));

		return pageInfo.getList();
	}

}
