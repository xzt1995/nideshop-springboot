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
@Table(name = "nideshop_order_express")
public class NideshopOrderExpress {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private Integer orderId;
    private Integer shipperId;
    private String shipperName;
    private String shipperCode;
    private String logisticCode;
    private String traces;
    private Integer isFinish;
    private Integer requestCount;
    private Integer requestTime;
    private Integer addTime;
    private Integer updateTime;

}
