package com.ruoyi.shop.mapper;


import com.ruoyi.shop.domain.NideshopUser;

import java.util.List;

/**
 * 会员Mapper接口
 *
 * @author ruoyi
 * @date 2019-11-28
 */
public interface NideshopUserMapper
{
    /**
     * 查询会员
     *
     * @param id 会员ID
     * @return 会员
     */
    public NideshopUser selectNideshopUserById(Integer id);

    /**
     * 查询会员列表
     *
     * @param nideshopUser 会员
     * @return 会员集合
     */
    public List<NideshopUser> selectNideshopUserList(NideshopUser nideshopUser);

    /**
     * 新增会员
     *
     * @param nideshopUser 会员
     * @return 结果
     */
    public int insertNideshopUser(NideshopUser nideshopUser);

    /**
     * 修改会员
     *
     * @param nideshopUser 会员
     * @return 结果
     */
    public int updateNideshopUser(NideshopUser nideshopUser);

    /**
     * 删除会员
     *
     * @param id 会员ID
     * @return 结果
     */
    public int deleteNideshopUserById(Integer id);

    /**
     * 批量删除会员
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteNideshopUserByIds(String[] ids);
}
