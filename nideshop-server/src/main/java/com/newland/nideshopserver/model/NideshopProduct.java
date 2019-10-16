package com.newland.nideshopserver.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author xzt
 * @CREATE2019-09-29 12:24
 */
@Getter
@Setter
@ToString
@Table(name = "nideshop_product")
public class NideshopProduct {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private Integer goodsId;
    private String goodsSpecificationIds;
    private String goodsSn;
    private Integer goodsNumber;
    private BigDecimal retailPrice;

}
