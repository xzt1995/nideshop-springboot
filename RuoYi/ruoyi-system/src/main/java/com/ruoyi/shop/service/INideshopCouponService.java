package com.ruoyi.shop.service;


import com.ruoyi.shop.domain.NideshopCoupon;

import java.util.List;

/**
 * 优惠卷红包Service接口
 *
 * @author ruoyi
 * @date 2019-11-29
 */
public interface INideshopCouponService
{
    /**
     * 查询优惠卷红包
     *
     * @param id 优惠卷红包ID
     * @return 优惠卷红包
     */
    public NideshopCoupon selectNideshopCouponById(Integer id);

    /**
     * 查询优惠卷红包列表
     *
     * @param nideshopCoupon 优惠卷红包
     * @return 优惠卷红包集合
     */
    public List<NideshopCoupon> selectNideshopCouponList(NideshopCoupon nideshopCoupon);

    /**
     * 新增优惠卷红包
     *
     * @param nideshopCoupon 优惠卷红包
     * @return 结果
     */
    public int insertNideshopCoupon(NideshopCoupon nideshopCoupon);

    /**
     * 修改优惠卷红包
     *
     * @param nideshopCoupon 优惠卷红包
     * @return 结果
     */
    public int updateNideshopCoupon(NideshopCoupon nideshopCoupon);

    /**
     * 批量删除优惠卷红包
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteNideshopCouponByIds(String ids);

    /**
     * 删除优惠卷红包信息
     *
     * @param id 优惠卷红包ID
     * @return 结果
     */
    public int deleteNideshopCouponById(Integer id);
}
