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
@Getter
@Setter
@ToString
@Table(name = "nideshop_collect")
public class NideshopCollect {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private Integer userId;
    private Integer valueId;
    private Long addTime;
    private Integer isAttention;
    private Integer typeId;
}
