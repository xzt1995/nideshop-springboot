package com.ruoyi.shop.service.impl;

import java.util.List;

import com.ruoyi.shop.domain.NideshopGoods;
import com.ruoyi.shop.mapper.NideshopGoodsMapper;
import com.ruoyi.shop.service.INideshopGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 商品信息Service业务层处理
 *
 * @author ruoyi
 * @date 2019-11-29
 */
@Service
public class NideshopGoodsServiceImpl implements INideshopGoodsService
{
    @Autowired
    private NideshopGoodsMapper nideshopGoodsMapper;

    /**
     * 查询商品信息
     *
     * @param id 商品信息ID
     * @return 商品信息
     */
    @Override
    public NideshopGoods selectNideshopGoodsById(Long id)
    {
        return nideshopGoodsMapper.selectNideshopGoodsById(id);
    }

    /**
     * 查询商品信息列表
     *
     * @param nideshopGoods 商品信息
     * @return 商品信息
     */
    @Override
    public List<NideshopGoods> selectNideshopGoodsList(NideshopGoods nideshopGoods)
    {
        return nideshopGoodsMapper.selectNideshopGoodsList(nideshopGoods);
    }

    /**
     * 新增商品信息
     *
     * @param nideshopGoods 商品信息
     * @return 结果
     */
    @Override
    public int insertNideshopGoods(NideshopGoods nideshopGoods)
    {
        return nideshopGoodsMapper.insertNideshopGoods(nideshopGoods);
    }

    /**
     * 修改商品信息
     *
     * @param nideshopGoods 商品信息
     * @return 结果
     */
    @Override
    public int updateNideshopGoods(NideshopGoods nideshopGoods)
    {
        return nideshopGoodsMapper.updateNideshopGoods(nideshopGoods);
    }

    /**
     * 删除商品信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteNideshopGoodsByIds(String ids)
    {
        return nideshopGoodsMapper.deleteNideshopGoodsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品信息信息
     *
     * @param id 商品信息ID
     * @return 结果
     */
    @Override
    public int deleteNideshopGoodsById(Long id)
    {
        return nideshopGoodsMapper.deleteNideshopGoodsById(id);
    }
}
