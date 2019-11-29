package com.ruoyi.shop.service.impl;

import java.util.List;

import com.ruoyi.shop.domain.NideshopShipper;
import com.ruoyi.shop.mapper.NideshopShipperMapper;
import com.ruoyi.shop.service.INideshopShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;

/**
 * 快递公司Service业务层处理
 *
 * @author ruoyi
 * @date 2019-11-28
 */
@Service
public class NideshopShipperServiceImpl implements INideshopShipperService
{
    @Autowired
    private NideshopShipperMapper nideshopShipperMapper;

    /**
     * 查询快递公司
     *
     * @param id 快递公司ID
     * @return 快递公司
     */
    @Override
    public NideshopShipper selectNideshopShipperById(Long id)
    {
        return nideshopShipperMapper.selectNideshopShipperById(id);
    }

    /**
     * 查询快递公司列表
     *
     * @param nideshopShipper 快递公司
     * @return 快递公司
     */
    @Override
    public List<NideshopShipper> selectNideshopShipperList(NideshopShipper nideshopShipper)
    {
        return nideshopShipperMapper.selectNideshopShipperList(nideshopShipper);
    }

    /**
     * 新增快递公司
     *
     * @param nideshopShipper 快递公司
     * @return 结果
     */
    @Override
    public int insertNideshopShipper(NideshopShipper nideshopShipper)
    {
        return nideshopShipperMapper.insertNideshopShipper(nideshopShipper);
    }

    /**
     * 修改快递公司
     *
     * @param nideshopShipper 快递公司
     * @return 结果
     */
    @Override
    public int updateNideshopShipper(NideshopShipper nideshopShipper)
    {
        return nideshopShipperMapper.updateNideshopShipper(nideshopShipper);
    }

    /**
     * 删除快递公司对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteNideshopShipperByIds(String ids)
    {
        return nideshopShipperMapper.deleteNideshopShipperByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除快递公司信息
     *
     * @param id 快递公司ID
     * @return 结果
     */
    @Override
    public int deleteNideshopShipperById(Long id)
    {
        return nideshopShipperMapper.deleteNideshopShipperById(id);
    }
}
