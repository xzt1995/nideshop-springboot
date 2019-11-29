package com.ruoyi.shop.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 会员对象 nideshop_user
 *
 * @author ruoyi
 * @date 2019-11-28
 */
public class NideshopUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Integer id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String username;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

    /** 性别 */
    @Excel(name = "性别")
    private Integer gender;

    /** 生日 */
    @Excel(name = "生日")
    private Long birthday;

    /** 注册时间 */
    @Excel(name = "注册时间")
    private Long registerTime;

    /** 上一次登录时间 */
    @Excel(name = "上一次登录时间")
    private Long lastLoginTime;

    /** 上一次登录IP */
    @Excel(name = "上一次登录IP")
    private String lastLoginIp;

    /** 等级 */
    @Excel(name = "等级")
    private Integer userLevelId;

    /** 昵称 */
    @Excel(name = "昵称")
    private String nickname;

    /** 手机号 */
    @Excel(name = "手机号")
    private String mobile;

    /** 注册IP */
    @Excel(name = "注册IP")
    private String registerIp;

    /** 头像 */
    @Excel(name = "头像")
    private String avatar;

    /** $column.columnComment */
    @Excel(name = "头像")
    private String weixinOpenid;

    /** $column.columnComment */
    @Excel(name = "头像")
    private String token;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getUsername()
    {
        return username;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }
    public void setGender(Integer gender)
    {
        this.gender = gender;
    }

    public Integer getGender()
    {
        return gender;
    }
    public void setBirthday(Long birthday)
    {
        this.birthday = birthday;
    }

    public Long getBirthday()
    {
        return birthday;
    }
    public void setRegisterTime(Long registerTime)
    {
        this.registerTime = registerTime;
    }

    public Long getRegisterTime()
    {
        return registerTime;
    }
    public void setLastLoginTime(Long lastLoginTime)
    {
        this.lastLoginTime = lastLoginTime;
    }

    public Long getLastLoginTime()
    {
        return lastLoginTime;
    }
    public void setLastLoginIp(String lastLoginIp)
    {
        this.lastLoginIp = lastLoginIp;
    }

    public String getLastLoginIp()
    {
        return lastLoginIp;
    }
    public void setUserLevelId(Integer userLevelId)
    {
        this.userLevelId = userLevelId;
    }

    public Integer getUserLevelId()
    {
        return userLevelId;
    }
    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    public String getNickname()
    {
        return nickname;
    }
    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getMobile()
    {
        return mobile;
    }
    public void setRegisterIp(String registerIp)
    {
        this.registerIp = registerIp;
    }

    public String getRegisterIp()
    {
        return registerIp;
    }
    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }

    public String getAvatar()
    {
        return avatar;
    }
    public void setWeixinOpenid(String weixinOpenid)
    {
        this.weixinOpenid = weixinOpenid;
    }

    public String getWeixinOpenid()
    {
        return weixinOpenid;
    }
    public void setToken(String token)
    {
        this.token = token;
    }

    public String getToken()
    {
        return token;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("username", getUsername())
            .append("password", getPassword())
            .append("gender", getGender())
            .append("birthday", getBirthday())
            .append("registerTime", getRegisterTime())
            .append("lastLoginTime", getLastLoginTime())
            .append("lastLoginIp", getLastLoginIp())
            .append("userLevelId", getUserLevelId())
            .append("nickname", getNickname())
            .append("mobile", getMobile())
            .append("registerIp", getRegisterIp())
            .append("avatar", getAvatar())
            .append("weixinOpenid", getWeixinOpenid())
            .append("token", getToken())
            .toString();
    }
}
