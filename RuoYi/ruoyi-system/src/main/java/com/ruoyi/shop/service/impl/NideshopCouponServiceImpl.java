package com.ruoyi.shop.service.impl;

import java.util.List;

import com.ruoyi.shop.domain.NideshopCoupon;
import com.ruoyi.shop.mapper.NideshopCouponMapper;
import com.ruoyi.shop.service.INideshopCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;

/**
 * 优惠卷红包Service业务层处理
 *
 * @author ruoyi
 * @date 2019-11-29
 */
@Service
public class NideshopCouponServiceImpl implements INideshopCouponService
{
    @Autowired
    private NideshopCouponMapper nideshopCouponMapper;

    /**
     * 查询优惠卷红包
     *
     * @param id 优惠卷红包ID
     * @return 优惠卷红包
     */
    @Override
    public NideshopCoupon selectNideshopCouponById(Integer id)
    {
        return nideshopCouponMapper.selectNideshopCouponById(id);
    }

    /**
     * 查询优惠卷红包列表
     *
     * @param nideshopCoupon 优惠卷红包
     * @return 优惠卷红包
     */
    @Override
    public List<NideshopCoupon> selectNideshopCouponList(NideshopCoupon nideshopCoupon)
    {
        return nideshopCouponMapper.selectNideshopCouponList(nideshopCoupon);
    }

    /**
     * 新增优惠卷红包
     *
     * @param nideshopCoupon 优惠卷红包
     * @return 结果
     */
    @Override
    public int insertNideshopCoupon(NideshopCoupon nideshopCoupon)
    {
        return nideshopCouponMapper.insertNideshopCoupon(nideshopCoupon);
    }

    /**
     * 修改优惠卷红包
     *
     * @param nideshopCoupon 优惠卷红包
     * @return 结果
     */
    @Override
    public int updateNideshopCoupon(NideshopCoupon nideshopCoupon)
    {
        return nideshopCouponMapper.updateNideshopCoupon(nideshopCoupon);
    }

    /**
     * 删除优惠卷红包对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteNideshopCouponByIds(String ids)
    {
        return nideshopCouponMapper.deleteNideshopCouponByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除优惠卷红包信息
     *
     * @param id 优惠卷红包ID
     * @return 结果
     */
    @Override
    public int deleteNideshopCouponById(Integer id)
    {
        return nideshopCouponMapper.deleteNideshopCouponById(id);
    }
}
