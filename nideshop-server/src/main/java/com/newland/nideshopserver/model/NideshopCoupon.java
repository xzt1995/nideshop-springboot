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
 * @CREATE2019-09-29 12:23
 */
@Getter
@Setter
@ToString
@Table(name = "nideshop_coupon")
public class NideshopCoupon {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String name;
    private BigDecimal typeMoney;
    private Integer sendType;
    private BigDecimal minAmount;
    private BigDecimal maxAmount;
    private Integer sendStartDate;
    private Integer sendEndDate;
    private Integer useStartDate;
    private Integer useEndDate;
    private BigDecimal minGoodsAmount;
}
