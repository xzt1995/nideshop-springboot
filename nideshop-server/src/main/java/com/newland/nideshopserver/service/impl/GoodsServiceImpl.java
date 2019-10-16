package com.newland.nideshopserver.service.impl;

import com.newland.nideshopserver.mapper.GoodsMapper;
import com.newland.nideshopserver.model.NideshopGoods;
import com.newland.nideshopserver.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author xzt
 * @CREATE2019-10-11 11:36
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<NideshopGoods> listNewGoods() {
        NideshopGoods g = new NideshopGoods();
        g.setIsNew(1);
        List<NideshopGoods> list = goodsMapper.select(g);
        return  list;
    }

    @Override
    public List<NideshopGoods> listHotGoods() {
        NideshopGoods g = new NideshopGoods();
        g.setIsHot(1);
        List<NideshopGoods> list = goodsMapper.select(g);
        return  list;
    }

    @Override
    public int goodsCount() {
        int count = goodsMapper.goodsCount();
        return count;
    }
}
