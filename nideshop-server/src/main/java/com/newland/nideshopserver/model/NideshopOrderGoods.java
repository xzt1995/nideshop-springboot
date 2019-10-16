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
@Table(name = "nideshop_order_goods")
public class NideshopOrderGoods {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private Integer orderId;
    private Integer goodsId;
    private String goodsName;
    private String goodsSn;
    private Integer productId;
    private Integer number;
    private BigDecimal marketPrice;
    private BigDecimal retailPrice;
    private String goodsSpecifitionNameValue;
    private Integer isReal;
    private String goodsSpecifitionIds;
    private String listPicUrl;
}
