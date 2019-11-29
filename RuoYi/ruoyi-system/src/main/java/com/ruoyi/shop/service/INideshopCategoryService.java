package com.ruoyi.shop.service;


import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.shop.domain.NideshopCategory;

import java.util.List;

/**
 * 商品分类Service接口
 *
 * @author ruoyi
 * @date 2019-11-28
 */
public interface INideshopCategoryService
{
    /**
     * 查询商品分类
     *
     * @param id 商品分类ID
     * @return 商品分类
     */
    public NideshopCategory selectNideshopCategoryById(Long id);

    /**
     * 查询商品分类列表
     *
     * @param nideshopCategory 商品分类
     * @return 商品分类集合
     */
    public List<NideshopCategory> selectNideshopCategoryList(NideshopCategory nideshopCategory);

    /**
     * 新增商品分类
     *
     * @param nideshopCategory 商品分类
     * @return 结果
     */
    public int insertNideshopCategory(NideshopCategory nideshopCategory);

    /**
     * 修改商品分类
     *
     * @param nideshopCategory 商品分类
     * @return 结果
     */
    public int updateNideshopCategory(NideshopCategory nideshopCategory);

    /**
     * 批量删除商品分类
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteNideshopCategoryByIds(String ids);

    /**
     * 删除商品分类信息
     *
     * @param id 商品分类ID
     * @return 结果
     */
    public int deleteNideshopCategoryById(Long id);

    /**
     * 查询商城商品分类树列表
     *
     * @return 所有商城商品分类信息
     */
    public List<Ztree> selectNideshopCategoryTree();
}
