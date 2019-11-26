package com.ruoyi.shop.service.impl;

import java.util.List;
import com.ruoyi.shop.domain.NideshopTopic;
import com.ruoyi.shop.mapper.NideshopTopicMapper;
import com.ruoyi.shop.service.INideshopTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 商品专题Service业务层处理
 *
 * @author ruoyi
 * @date 2019-11-26
 */
@Service
public class NideshopTopicServiceImpl implements INideshopTopicService
{
    @Autowired
    private NideshopTopicMapper nideshopTopicMapper;

    /**
     * 查询商品专题
     *
     * @param id 商品专题ID
     * @return 商品专题
     */
    @Override
    public NideshopTopic selectNideshopTopicById(Integer id)
    {
        return nideshopTopicMapper.selectNideshopTopicById(id);
    }

    /**
     * 查询商品专题列表
     *
     * @param nideshopTopic 商品专题
     * @return 商品专题
     */
    @Override
    public List<NideshopTopic> selectNideshopTopicList(NideshopTopic nideshopTopic)
    {
        return nideshopTopicMapper.selectNideshopTopicList(nideshopTopic);
    }

    /**
     * 新增商品专题
     *
     * @param nideshopTopic 商品专题
     * @return 结果
     */
    @Override
    public int insertNideshopTopic(NideshopTopic nideshopTopic)
    {
        return nideshopTopicMapper.insertNideshopTopic(nideshopTopic);
    }

    /**
     * 修改商品专题
     *
     * @param nideshopTopic 商品专题
     * @return 结果
     */
    @Override
    public int updateNideshopTopic(NideshopTopic nideshopTopic)
    {
        return nideshopTopicMapper.updateNideshopTopic(nideshopTopic);
    }

    /**
     * 删除商品专题对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteNideshopTopicByIds(String ids)
    {
        return nideshopTopicMapper.deleteNideshopTopicByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品专题信息
     *
     * @param id 商品专题ID
     * @return 结果
     */
    @Override
    public int deleteNideshopTopicById(Integer id)
    {
        return nideshopTopicMapper.deleteNideshopTopicById(id);
    }
}
