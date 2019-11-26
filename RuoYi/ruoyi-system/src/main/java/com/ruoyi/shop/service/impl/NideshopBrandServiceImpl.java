package com.ruoyi.shop.service.impl;

import java.util.List;

import com.ruoyi.shop.domain.NideshopBrand;
import com.ruoyi.shop.mapper.NideshopBrandMapper;
import com.ruoyi.shop.service.INideshopBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 商城品牌列Service业务层处理
 *
 * @author ruoyi
 * @date 2019-11-26
 */
@Service
public class NideshopBrandServiceImpl implements INideshopBrandService
{
    @Autowired
    private NideshopBrandMapper nideshopBrandMapper;

    /**
     * 查询商城品牌列
     *
     * @param id 商城品牌列ID
     * @return 商城品牌列
     */
    @Override
    public NideshopBrand selectNideshopBrandById(Long id)
    {
        return nideshopBrandMapper.selectNideshopBrandById(id);
    }

    /**
     * 查询商城品牌列列表
     *
     * @param nideshopBrand 商城品牌列
     * @return 商城品牌列
     */
    @Override
    public List<NideshopBrand> selectNideshopBrandList(NideshopBrand nideshopBrand)
    {
        return nideshopBrandMapper.selectNideshopBrandList(nideshopBrand);
    }

    /**
     * 新增商城品牌列
     *
     * @param nideshopBrand 商城品牌列
     * @return 结果
     */
    @Override
    public int insertNideshopBrand(NideshopBrand nideshopBrand)
    {
        return nideshopBrandMapper.insertNideshopBrand(nideshopBrand);
    }

    /**
     * 修改商城品牌列
     *
     * @param nideshopBrand 商城品牌列
     * @return 结果
     */
    @Override
    public int updateNideshopBrand(NideshopBrand nideshopBrand)
    {
        return nideshopBrandMapper.updateNideshopBrand(nideshopBrand);
    }

    /**
     * 删除商城品牌列对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteNideshopBrandByIds(String ids)
    {
        return nideshopBrandMapper.deleteNideshopBrandByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商城品牌列信息
     *
     * @param id 商城品牌列ID
     * @return 结果
     */
    @Override
    public int deleteNideshopBrandById(Long id)
    {
        return nideshopBrandMapper.deleteNideshopBrandById(id);
    }
}
