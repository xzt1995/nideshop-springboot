package com.ruoyi.shop.service;


import com.ruoyi.shop.domain.NideshopTopic;

import java.util.List;

/**
 * 商品专题Service接口
 *
 * @author ruoyi
 * @date 2019-11-26
 */
public interface INideshopTopicService
{
    /**
     * 查询商品专题
     *
     * @param id 商品专题ID
     * @return 商品专题
     */
    public NideshopTopic selectNideshopTopicById(Integer id);

    /**
     * 查询商品专题列表
     *
     * @param nideshopTopic 商品专题
     * @return 商品专题集合
     */
    public List<NideshopTopic> selectNideshopTopicList(NideshopTopic nideshopTopic);

    /**
     * 新增商品专题
     *
     * @param nideshopTopic 商品专题
     * @return 结果
     */
    public int insertNideshopTopic(NideshopTopic nideshopTopic);

    /**
     * 修改商品专题
     *
     * @param nideshopTopic 商品专题
     * @return 结果
     */
    public int updateNideshopTopic(NideshopTopic nideshopTopic);

    /**
     * 批量删除商品专题
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteNideshopTopicByIds(String ids);

    /**
     * 删除商品专题信息
     *
     * @param id 商品专题ID
     * @return 结果
     */
    public int deleteNideshopTopicById(Integer id);
}
