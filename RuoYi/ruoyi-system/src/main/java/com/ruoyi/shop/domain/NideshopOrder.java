package com.ruoyi.shop.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 订单对象 nideshop_order
 *
 * @author ruoyi
 * @date 2019-11-28
 */
public class NideshopOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Integer id;

    /** 订单编号 */
    @Excel(name = "订单编号", readConverterExp = "$column.readConverterExp()")
    private String orderSn;

    /** 用户ID */
    @Excel(name = "用户ID", readConverterExp = "$column.readConverterExp()")
    private Integer userId;

    /** 订单状态 */
    @Excel(name = "订单状态", readConverterExp = "$column.readConverterExp()")
    private Integer orderStatus;

    /** 发货状态*/
    @Excel(name = "发货状态", readConverterExp = "$column.readConverterExp()")
    private Integer shippingStatus;

    /** 支付状态 */
    @Excel(name = "支付状态", readConverterExp = "$column.readConverterExp()")
    private Integer payStatus;

    /** 收货人 */
    @Excel(name = "收货人", readConverterExp = "$column.readConverterExp()")
    private String consignee;

    /** 国家 */
    @Excel(name = "国家", readConverterExp = "$column.readConverterExp()")
    private Integer country;

    /** 省份 */
    @Excel(name = "省份", readConverterExp = "$column.readConverterExp()")
    private Integer province;

    /** 城市 */
    @Excel(name = "城市", readConverterExp = "$column.readConverterExp()")
    private Integer city;

    /** 区 */
    @Excel(name = "区", readConverterExp = "$column.readConverterExp()")
    private Integer district;

    /** 地址 */
    @Excel(name = "地址", readConverterExp = "$column.readConverterExp()")
    private String address;

    /** 手机号 */
    @Excel(name = "手机号", readConverterExp = "$column.readConverterExp()")
    private String mobile;

    /** 后记 */
    //@Excel(name = "后记", readConverterExp = "$column.readConverterExp()")
    private String postscript;

    /** 运费 */
    @Excel(name = "运费", readConverterExp = "$column.readConverterExp()")
    private Double shippingFee;

    /** 支付人 */
    @Excel(name = "支付人", readConverterExp = "$column.readConverterExp()")
    private String payName;

    /** 支付ID */
    @Excel(name = "支付ID", readConverterExp = "$column.readConverterExp()")
    private Integer payId;

    /** 实际需要支付的金额 */
    @Excel(name = "实际需要支付的金额", readConverterExp = "$column.readConverterExp()")
    private Double actualPrice;

    /** 积分 */
    @Excel(name = "积分", readConverterExp = "$column.readConverterExp()")
    private Integer integral;

    /** 积分货币 */
    @Excel(name = "积分货币", readConverterExp = "$column.readConverterExp()")
    private Double integralMoney;

    /** 订单总价 */
    @Excel(name = "订单总价", readConverterExp = "$column.readConverterExp()")
    private Double orderPrice;

    /** 商品总价 */
    @Excel(name = "商品总价", readConverterExp = "$column.readConverterExp()")
    private Double goodsPrice;

    /** 生成时间 */
    @Excel(name = "生成时间", readConverterExp = "$column.readConverterExp()")
    private Long addTime;

    /** 确认时间 */
    @Excel(name = "确认时间", readConverterExp = "$column.readConverterExp()")
    private Long confirmTime;

    /** 支付时间 */
    @Excel(name = "支付时间", readConverterExp = "$column.readConverterExp()")
    private Long payTime;

    /** 配送费用 */
    @Excel(name = "配送费用", readConverterExp = "$column.readConverterExp()")
    private Integer freightPrice;

    /** 使用的优惠券id */
    @Excel(name = "使用的优惠券id", readConverterExp = "$column.readConverterExp()")
    private Integer couponId;


    private Integer parentId;

    /** 优惠券价格 */
    @Excel(name = "优惠券价格", readConverterExp = "$column.readConverterExp()")
    private Double couponPrice;

    /** 回调状态*/
   // @Excel(name = "回调状态", readConverterExp = "$column.readConverterExp()")
    private String callbackStatus;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setOrderSn(String orderSn)
    {
        this.orderSn = orderSn;
    }

    public String getOrderSn()
    {
        return orderSn;
    }
    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public Integer getUserId()
    {
        return userId;
    }
    public void setOrderStatus(Integer orderStatus)
    {
        this.orderStatus = orderStatus;
    }

    public Integer getOrderStatus()
    {
        return orderStatus;
    }
    public void setShippingStatus(Integer shippingStatus)
    {
        this.shippingStatus = shippingStatus;
    }

    public Integer getShippingStatus()
    {
        return shippingStatus;
    }
    public void setPayStatus(Integer payStatus)
    {
        this.payStatus = payStatus;
    }

    public Integer getPayStatus()
    {
        return payStatus;
    }
    public void setConsignee(String consignee)
    {
        this.consignee = consignee;
    }

    public String getConsignee()
    {
        return consignee;
    }
    public void setCountry(Integer country)
    {
        this.country = country;
    }

    public Integer getCountry()
    {
        return country;
    }
    public void setProvince(Integer province)
    {
        this.province = province;
    }

    public Integer getProvince()
    {
        return province;
    }
    public void setCity(Integer city)
    {
        this.city = city;
    }

    public Integer getCity()
    {
        return city;
    }
    public void setDistrict(Integer district)
    {
        this.district = district;
    }

    public Integer getDistrict()
    {
        return district;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }
    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getMobile()
    {
        return mobile;
    }
    public void setPostscript(String postscript)
    {
        this.postscript = postscript;
    }

    public String getPostscript()
    {
        return postscript;
    }
    public void setShippingFee(Double shippingFee)
    {
        this.shippingFee = shippingFee;
    }

    public Double getShippingFee()
    {
        return shippingFee;
    }
    public void setPayName(String payName)
    {
        this.payName = payName;
    }

    public String getPayName()
    {
        return payName;
    }
    public void setPayId(Integer payId)
    {
        this.payId = payId;
    }

    public Integer getPayId()
    {
        return payId;
    }
    public void setActualPrice(Double actualPrice)
    {
        this.actualPrice = actualPrice;
    }

    public Double getActualPrice()
    {
        return actualPrice;
    }
    public void setIntegral(Integer integral)
    {
        this.integral = integral;
    }

    public Integer getIntegral()
    {
        return integral;
    }
    public void setIntegralMoney(Double integralMoney)
    {
        this.integralMoney = integralMoney;
    }

    public Double getIntegralMoney()
    {
        return integralMoney;
    }
    public void setOrderPrice(Double orderPrice)
    {
        this.orderPrice = orderPrice;
    }

    public Double getOrderPrice()
    {
        return orderPrice;
    }
    public void setGoodsPrice(Double goodsPrice)
    {
        this.goodsPrice = goodsPrice;
    }

    public Double getGoodsPrice()
    {
        return goodsPrice;
    }
    public void setAddTime(Long addTime)
    {
        this.addTime = addTime;
    }

    public Long getAddTime()
    {
        return addTime;
    }
    public void setConfirmTime(Long confirmTime)
    {
        this.confirmTime = confirmTime;
    }

    public Long getConfirmTime()
    {
        return confirmTime;
    }
    public void setPayTime(Long payTime)
    {
        this.payTime = payTime;
    }

    public Long getPayTime()
    {
        return payTime;
    }
    public void setFreightPrice(Integer freightPrice)
    {
        this.freightPrice = freightPrice;
    }

    public Integer getFreightPrice()
    {
        return freightPrice;
    }
    public void setCouponId(Integer couponId)
    {
        this.couponId = couponId;
    }

    public Integer getCouponId()
    {
        return couponId;
    }
    public void setParentId(Integer parentId)
    {
        this.parentId = parentId;
    }

    public Integer getParentId()
    {
        return parentId;
    }
    public void setCouponPrice(Double couponPrice)
    {
        this.couponPrice = couponPrice;
    }

    public Double getCouponPrice()
    {
        return couponPrice;
    }
    public void setCallbackStatus(String callbackStatus)
    {
        this.callbackStatus = callbackStatus;
    }

    public String getCallbackStatus()
    {
        return callbackStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderSn", getOrderSn())
            .append("userId", getUserId())
            .append("orderStatus", getOrderStatus())
            .append("shippingStatus", getShippingStatus())
            .append("payStatus", getPayStatus())
            .append("consignee", getConsignee())
            .append("country", getCountry())
            .append("province", getProvince())
            .append("city", getCity())
            .append("district", getDistrict())
            .append("address", getAddress())
            .append("mobile", getMobile())
            .append("postscript", getPostscript())
            .append("shippingFee", getShippingFee())
            .append("payName", getPayName())
            .append("payId", getPayId())
            .append("actualPrice", getActualPrice())
            .append("integral", getIntegral())
            .append("integralMoney", getIntegralMoney())
            .append("orderPrice", getOrderPrice())
            .append("goodsPrice", getGoodsPrice())
            .append("addTime", getAddTime())
            .append("confirmTime", getConfirmTime())
            .append("payTime", getPayTime())
            .append("freightPrice", getFreightPrice())
            .append("couponId", getCouponId())
            .append("parentId", getParentId())
            .append("couponPrice", getCouponPrice())
            .append("callbackStatus", getCallbackStatus())
            .toString();
    }
}
