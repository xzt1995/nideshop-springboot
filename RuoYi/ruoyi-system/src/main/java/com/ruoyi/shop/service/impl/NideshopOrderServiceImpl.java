package com.ruoyi.shop.service.impl;

import java.util.List;

import com.ruoyi.shop.domain.NideshopOrder;
import com.ruoyi.shop.mapper.NideshopOrderMapper;
import com.ruoyi.shop.service.INideshopOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 订单Service业务层处理
 *
 * @author ruoyi
 * @date 2019-11-28
 */
@Service
public class NideshopOrderServiceImpl implements INideshopOrderService
{
    @Autowired
    private NideshopOrderMapper nideshopOrderMapper;

    /**
     * 查询订单
     *
     * @param id 订单ID
     * @return 订单
     */
    @Override
    public NideshopOrder selectNideshopOrderById(Integer id)
    {
        return nideshopOrderMapper.selectNideshopOrderById(id);
    }

    /**
     * 查询订单列表
     *
     * @param nideshopOrder 订单
     * @return 订单
     */
    @Override
    public List<NideshopOrder> selectNideshopOrderList(NideshopOrder nideshopOrder)
    {
        return nideshopOrderMapper.selectNideshopOrderList(nideshopOrder);
    }

    /**
     * 新增订单
     *
     * @param nideshopOrder 订单
     * @return 结果
     */
    @Override
    public int insertNideshopOrder(NideshopOrder nideshopOrder)
    {
        return nideshopOrderMapper.insertNideshopOrder(nideshopOrder);
    }

    /**
     * 修改订单
     *
     * @param nideshopOrder 订单
     * @return 结果
     */
    @Override
    public int updateNideshopOrder(NideshopOrder nideshopOrder)
    {
        return nideshopOrderMapper.updateNideshopOrder(nideshopOrder);
    }

    /**
     * 删除订单对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteNideshopOrderByIds(String ids)
    {
        return nideshopOrderMapper.deleteNideshopOrderByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除订单信息
     *
     * @param id 订单ID
     * @return 结果
     */
    @Override
    public int deleteNideshopOrderById(Integer id)
    {
        return nideshopOrderMapper.deleteNideshopOrderById(id);
    }
}
