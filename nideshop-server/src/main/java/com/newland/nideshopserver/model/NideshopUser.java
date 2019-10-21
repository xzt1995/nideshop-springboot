package com.newland.nideshopserver.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author xzt
 * @CREATE2019-09-29 12:24
 */
@Getter
@Setter
@ToString
@Table(name = "nideshop_user")
public class NideshopUser {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String username;
    private String password;
    private Byte gender;
    private Integer birthday;
    private Integer registerTime;
    private Integer lastLoginTime;
    private String lastLoginIp;
    private Integer userLevelId;
    private String nickname;
    private String mobile;
    private String registerIp;
    private String avatar;
    private String weixinOpenid;

}
