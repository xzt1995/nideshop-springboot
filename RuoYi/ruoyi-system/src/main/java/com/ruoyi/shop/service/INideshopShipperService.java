package com.ruoyi.shop.service;

import com.ruoyi.shop.domain.NideshopShipper;

import java.util.List;

/**
 * 快递公司Service接口
 *
 * @author ruoyi
 * @date 2019-11-28
 */
public interface INideshopShipperService
{
    /**
     * 查询快递公司
     *
     * @param id 快递公司ID
     * @return 快递公司
     */
    public NideshopShipper selectNideshopShipperById(Long id);

    /**
     * 查询快递公司列表
     *
     * @param nideshopShipper 快递公司
     * @return 快递公司集合
     */
    public List<NideshopShipper> selectNideshopShipperList(NideshopShipper nideshopShipper);

    /**
     * 新增快递公司
     *
     * @param nideshopShipper 快递公司
     * @return 结果
     */
    public int insertNideshopShipper(NideshopShipper nideshopShipper);

    /**
     * 修改快递公司
     *
     * @param nideshopShipper 快递公司
     * @return 结果
     */
    public int updateNideshopShipper(NideshopShipper nideshopShipper);

    /**
     * 批量删除快递公司
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteNideshopShipperByIds(String ids);

    /**
     * 删除快递公司信息
     *
     * @param id 快递公司ID
     * @return 结果
     */
    public int deleteNideshopShipperById(Long id);
}
