package com.newland.nideshopserver.service;

import com.newland.nideshopserver.model.NideshopGoods;

import java.util.List;

/**
 * @author xzt
 * @create 2019-10-11 11:35
 */
public interface GoodsService {
    List<NideshopGoods> listNewGoods();
    List<NideshopGoods> listHotGoods();
    int goodsCount();
}
