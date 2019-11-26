package com.ruoyi.shop.service.impl;

import java.util.List;
import com.ruoyi.shop.domain.NideshopAd;
import com.ruoyi.shop.mapper.NideshopAdMapper;
import com.ruoyi.shop.service.INideshopAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 首页轮播广告Service业务层处理
 *
 * @author ruoyi
 * @date 2019-11-26
 */
@Service
public class NideshopAdServiceImpl implements INideshopAdService
{
    @Autowired
    private NideshopAdMapper nideshopAdMapper;

    /**
     * 查询首页轮播广告
     *
     * @param id 首页轮播广告ID
     * @return 首页轮播广告
     */
    @Override
    public NideshopAd selectNideshopAdById(Integer id)
    {
        return nideshopAdMapper.selectNideshopAdById(id);
    }

    /**
     * 查询首页轮播广告列表
     *
     * @param nideshopAd 首页轮播广告
     * @return 首页轮播广告
     */
    @Override
    public List<NideshopAd> selectNideshopAdList(NideshopAd nideshopAd)
    {
        return nideshopAdMapper.selectNideshopAdList(nideshopAd);
    }

    /**
     * 新增首页轮播广告
     *
     * @param nideshopAd 首页轮播广告
     * @return 结果
     */
    @Override
    public int insertNideshopAd(NideshopAd nideshopAd)
    {
        return nideshopAdMapper.insertNideshopAd(nideshopAd);
    }

    /**
     * 修改首页轮播广告
     *
     * @param nideshopAd 首页轮播广告
     * @return 结果
     */
    @Override
    public int updateNideshopAd(NideshopAd nideshopAd)
    {
        return nideshopAdMapper.updateNideshopAd(nideshopAd);
    }

    /**
     * 删除首页轮播广告对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteNideshopAdByIds(String ids)
    {
        return nideshopAdMapper.deleteNideshopAdByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除首页轮播广告信息
     *
     * @param id 首页轮播广告ID
     * @return 结果
     */
    @Override
    public int deleteNideshopAdById(Integer id)
    {
        return nideshopAdMapper.deleteNideshopAdById(id);
    }
}
