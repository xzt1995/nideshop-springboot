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
@Table(name = "nideshop_user_level")
public class NideshopUserLevel {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Byte id;
    private String name;
    private String description;
}
