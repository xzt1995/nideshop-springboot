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
@Table(name = "nideshop_cart")
public class NideshopCart {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private Integer userId;
    private String sessionId;
    private Integer goodsId;
    private String goodsSn;
    private Integer productId;
    private String goodsName;
    private BigDecimal marketPrice;
    private BigDecimal retailPrice;
    private Integer number;
    private String goodsSpecifitionNameValue;
    private String goodsSpecifitionIds;
    private Integer checked;
    private String listPicUrl;
}
