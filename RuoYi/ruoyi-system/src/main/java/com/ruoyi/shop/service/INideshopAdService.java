package com.ruoyi.shop.service;

import com.ruoyi.shop.domain.NideshopAd;

import java.util.List;

/**
 * 首页轮播广告Service接口
 *
 * @author ruoyi
 * @date 2019-11-26
 */
public interface INideshopAdService
{
    /**
     * 查询首页轮播广告
     *
     * @param id 首页轮播广告ID
     * @return 首页轮播广告
     */
    public NideshopAd selectNideshopAdById(Integer id);

    /**
     * 查询首页轮播广告列表
     *
     * @param nideshopAd 首页轮播广告
     * @return 首页轮播广告集合
     */
    public List<NideshopAd> selectNideshopAdList(NideshopAd nideshopAd);

    /**
     * 新增首页轮播广告
     *
     * @param nideshopAd 首页轮播广告
     * @return 结果
     */
    public int insertNideshopAd(NideshopAd nideshopAd);

    /**
     * 修改首页轮播广告
     *
     * @param nideshopAd 首页轮播广告
     * @return 结果
     */
    public int updateNideshopAd(NideshopAd nideshopAd);

    /**
     * 批量删除首页轮播广告
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteNideshopAdByIds(String ids);

    /**
     * 删除首页轮播广告信息
     *
     * @param id 首页轮播广告ID
     * @return 结果
     */
    public int deleteNideshopAdById(Integer id);
}
