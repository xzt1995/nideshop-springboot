package com.newland.nideshopserver.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;

import com.newland.nideshopserver.model.dto.HandleOption;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author xzt @CREATE2019-09-29 12:24
 */
@Getter
@Setter
@ToString
@Table(name = "nideshop_order")
public class NideshopOrder {
	@Id
	@KeySql(useGeneratedKeys = true)
	private Integer id;
	private String orderSn;
	private Integer userId;
	private Integer orderStatus;
	private Integer shippingStatus;
	private Integer payStatus;
	private String consignee;
	private Integer country;
	private Integer province;
	private Integer city;
	private Integer district;
	private String address;
	private String mobile;
	private String postscript;
	private BigDecimal shippingFee;
	private String payName;
	private Integer payId;
	private BigDecimal actualPrice;
	private Integer integral;
	private BigDecimal integralMoney;
	private BigDecimal orderPrice;
	private BigDecimal goodsPrice;
	private Long addTime;
	private Long confirmTime;
	private Long payTime;
	private Integer freightPrice;
	private Integer couponId;
	private Integer parentId;
	private BigDecimal couponPrice;
	private String callbackStatus;
	@Transient
	private Integer goodsCount;
	@Transient
	private String statusText;
	@Transient
	private HandleOption handleOption;
	@Transient
	private List<NideshopOrderGoods> nideshopOrderGoods;
}
