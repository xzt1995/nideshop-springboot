package com.ruoyi.shop.service;

import com.ruoyi.shop.domain.NideshopBrand;
import java.util.List;

/**
 * 商城品牌列Service接口
 *
 * @author ruoyi
 * @date 2019-11-26
 */
public interface INideshopBrandService
{
    /**
     * 查询商城品牌列
     *
     * @param id 商城品牌列ID
     * @return 商城品牌列
     */
    public NideshopBrand selectNideshopBrandById(Long id);

    /**
     * 查询商城品牌列列表
     *
     * @param nideshopBrand 商城品牌列
     * @return 商城品牌列集合
     */
    public List<NideshopBrand> selectNideshopBrandList(NideshopBrand nideshopBrand);

    /**
     * 新增商城品牌列
     *
     * @param nideshopBrand 商城品牌列
     * @return 结果
     */
    public int insertNideshopBrand(NideshopBrand nideshopBrand);

    /**
     * 修改商城品牌列
     *
     * @param nideshopBrand 商城品牌列
     * @return 结果
     */
    public int updateNideshopBrand(NideshopBrand nideshopBrand);

    /**
     * 批量删除商城品牌列
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteNideshopBrandByIds(String ids);

    /**
     * 删除商城品牌列信息
     *
     * @param id 商城品牌列ID
     * @return 结果
     */
    public int deleteNideshopBrandById(Long id);
}
