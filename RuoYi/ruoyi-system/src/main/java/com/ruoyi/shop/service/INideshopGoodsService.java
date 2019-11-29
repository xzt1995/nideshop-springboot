package com.ruoyi.shop.service;


import com.ruoyi.shop.domain.NideshopGoods;

import java.util.List;

/**
 * 商品信息Service接口
 *
 * @author ruoyi
 * @date 2019-11-29
 */
public interface INideshopGoodsService
{
    /**
     * 查询商品信息
     *
     * @param id 商品信息ID
     * @return 商品信息
     */
    public NideshopGoods selectNideshopGoodsById(Long id);

    /**
     * 查询商品信息列表
     *
     * @param nideshopGoods 商品信息
     * @return 商品信息集合
     */
    public List<NideshopGoods> selectNideshopGoodsList(NideshopGoods nideshopGoods);

    /**
     * 新增商品信息
     *
     * @param nideshopGoods 商品信息
     * @return 结果
     */
    public int insertNideshopGoods(NideshopGoods nideshopGoods);

    /**
     * 修改商品信息
     *
     * @param nideshopGoods 商品信息
     * @return 结果
     */
    public int updateNideshopGoods(NideshopGoods nideshopGoods);

    /**
     * 批量删除商品信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteNideshopGoodsByIds(String ids);

    /**
     * 删除商品信息信息
     *
     * @param id 商品信息ID
     * @return 结果
     */
    public int deleteNideshopGoodsById(Long id);
}
