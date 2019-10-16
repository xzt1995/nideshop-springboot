package com.newland.nideshopserver.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author xzt
 * @CREATE2019-09-29 16:00
 */
@Table(name = "nideshop_admin")
@Getter
@Setter
@ToString
public class NideshopAdmin {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String username;
    private String password;
    private String passwordSalt;
    private String lastLoginIp;
    private Integer lastLogIntegerime;
    private Integer addTime;
    private Integer updateTime;
    private String avatar;
    private Integer adminRoleId;
}
