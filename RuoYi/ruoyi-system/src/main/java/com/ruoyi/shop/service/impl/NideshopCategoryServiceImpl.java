package com.ruoyi.shop.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.shop.domain.NideshopCategory;
import com.ruoyi.shop.mapper.NideshopCategoryMapper;
import com.ruoyi.shop.service.INideshopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;

/**
 * 商品分类Service业务层处理
 *
 * @author ruoyi
 * @date 2019-11-28
 */
@Service
public class NideshopCategoryServiceImpl implements INideshopCategoryService
{
    @Autowired
    private NideshopCategoryMapper nideshopCategoryMapper;

    /**
     * 查询商品分类
     *
     * @param id 商品分类ID
     * @return 商品分类
     */
    @Override
    public NideshopCategory selectNideshopCategoryById(Long id)
    {
        return nideshopCategoryMapper.selectNideshopCategoryById(id);
    }

    /**
     * 查询商品分类列表
     *
     * @param nideshopCategory 商品分类
     * @return 商品分类
     */
    @Override
    public List<NideshopCategory> selectNideshopCategoryList(NideshopCategory nideshopCategory)
    {
        return nideshopCategoryMapper.selectNideshopCategoryList(nideshopCategory);
    }

    /**
     * 新增商品分类
     *
     * @param nideshopCategory 商品分类
     * @return 结果
     */
    @Override
    public int insertNideshopCategory(NideshopCategory nideshopCategory)
    {
        return nideshopCategoryMapper.insertNideshopCategory(nideshopCategory);
    }

    /**
     * 修改商品分类
     *
     * @param nideshopCategory 商品分类
     * @return 结果
     */
    @Override
    public int updateNideshopCategory(NideshopCategory nideshopCategory)
    {
        return nideshopCategoryMapper.updateNideshopCategory(nideshopCategory);
    }

    /**
     * 删除商品分类对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteNideshopCategoryByIds(String ids)
    {
        return nideshopCategoryMapper.deleteNideshopCategoryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品分类信息
     *
     * @param id 商品分类ID
     * @return 结果
     */
    @Override
    public int deleteNideshopCategoryById(Long id)
    {
        return nideshopCategoryMapper.deleteNideshopCategoryById(id);
    }


    /**
     * 查询商城商品分类树列表
     *
     * @return 所有商城商品分类信息
     */
    @Override
    public List<Ztree> selectNideshopCategoryTree()
    {
        List<NideshopCategory> storeGoodsCateList = nideshopCategoryMapper.selectNideshopCategoryList(new NideshopCategory());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (NideshopCategory Cate : storeGoodsCateList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(Cate.getId());
            ztree.setpId(Cate.getParentId());
            ztree.setName(Cate.getName());
            ztree.setTitle(Cate.getName());
            ztrees.add(ztree);
        }
        return ztrees;
    }
}
