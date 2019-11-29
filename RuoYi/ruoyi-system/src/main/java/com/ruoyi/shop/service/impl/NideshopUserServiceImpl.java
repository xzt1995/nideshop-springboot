package com.ruoyi.shop.service.impl;

import java.util.List;

import com.ruoyi.shop.domain.NideshopUser;
import com.ruoyi.shop.mapper.NideshopUserMapper;
import com.ruoyi.shop.service.INideshopUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;

/**
 * 会员Service业务层处理
 *
 * @author ruoyi
 * @date 2019-11-28
 */
@Service
public class NideshopUserServiceImpl implements INideshopUserService
{
    @Autowired
    private NideshopUserMapper nideshopUserMapper;

    /**
     * 查询会员
     *
     * @param id 会员ID
     * @return 会员
     */
    @Override
    public NideshopUser selectNideshopUserById(Integer id)
    {
        return nideshopUserMapper.selectNideshopUserById(id);
    }

    /**
     * 查询会员列表
     *
     * @param nideshopUser 会员
     * @return 会员
     */
    @Override
    public List<NideshopUser> selectNideshopUserList(NideshopUser nideshopUser)
    {
        return nideshopUserMapper.selectNideshopUserList(nideshopUser);
    }

    /**
     * 新增会员
     *
     * @param nideshopUser 会员
     * @return 结果
     */
    @Override
    public int insertNideshopUser(NideshopUser nideshopUser)
    {
        return nideshopUserMapper.insertNideshopUser(nideshopUser);
    }

    /**
     * 修改会员
     *
     * @param nideshopUser 会员
     * @return 结果
     */
    @Override
    public int updateNideshopUser(NideshopUser nideshopUser)
    {
        return nideshopUserMapper.updateNideshopUser(nideshopUser);
    }

    /**
     * 删除会员对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteNideshopUserByIds(String ids)
    {
        return nideshopUserMapper.deleteNideshopUserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除会员信息
     *
     * @param id 会员ID
     * @return 结果
     */
    @Override
    public int deleteNideshopUserById(Integer id)
    {
        return nideshopUserMapper.deleteNideshopUserById(id);
    }
}
