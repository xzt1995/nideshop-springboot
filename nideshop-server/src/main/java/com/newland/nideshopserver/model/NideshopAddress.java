package com.newland.nideshopserver.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author xzt
 * @CREATE2019-09-29 12:23
 */

@Table(name = "nideshop_address")
@Getter
@Setter
@ToString
public class NideshopAddress {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String name;
    private Integer userId;
    private Integer countryId;
    private Integer provinceId;
    private Integer cityId;
    private Integer districtId;
    private String address;
    private String mobile;
    private Integer isDefault;
}
