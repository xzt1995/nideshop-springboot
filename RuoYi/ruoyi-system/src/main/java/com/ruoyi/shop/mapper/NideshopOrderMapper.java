package com.ruoyi.shop.mapper;


import com.ruoyi.shop.domain.NideshopOrder;

import java.util.List;

/**
 * 订单Mapper接口
 *
 * @author ruoyi
 * @date 2019-11-28
 */
public interface NideshopOrderMapper
{
    /**
     * 查询订单
     *
     * @param id 订单ID
     * @return 订单
     */
    public NideshopOrder selectNideshopOrderById(Integer id);

    /**
     * 查询订单列表
     *
     * @param nideshopOrder 订单
     * @return 订单集合
     */
    public List<NideshopOrder> selectNideshopOrderList(NideshopOrder nideshopOrder);

    /**
     * 新增订单
     *
     * @param nideshopOrder 订单
     * @return 结果
     */
    public int insertNideshopOrder(NideshopOrder nideshopOrder);

    /**
     * 修改订单
     *
     * @param nideshopOrder 订单
     * @return 结果
     */
    public int updateNideshopOrder(NideshopOrder nideshopOrder);

    /**
     * 删除订单
     *
     * @param id 订单ID
     * @return 结果
     */
    public int deleteNideshopOrderById(Integer id);

    /**
     * 批量删除订单
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteNideshopOrderByIds(String[] ids);
}
