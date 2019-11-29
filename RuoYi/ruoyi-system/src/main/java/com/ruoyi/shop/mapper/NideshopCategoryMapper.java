package com.ruoyi.shop.mapper;


import com.ruoyi.shop.domain.NideshopCategory;

import java.util.List;

/**
 * 商品分类Mapper接口
 *
 * @author ruoyi
 * @date 2019-11-28
 */
public interface NideshopCategoryMapper
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
     * 删除商品分类
     *
     * @param id 商品分类ID
     * @return 结果
     */
    public int deleteNideshopCategoryById(Long id);

    /**
     * 批量删除商品分类
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteNideshopCategoryByIds(String[] ids);
}
