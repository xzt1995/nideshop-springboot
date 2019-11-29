package com.ruoyi.shop.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 优惠卷红包对象 nideshop_coupon
 *
 * @author ruoyi
 * @date 2019-11-29
 */
public class NideshopCoupon extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Integer id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 金额类型 */
    @Excel(name = "金额类型")
    private Double typeMoney;

    /** 发送方式 */
    @Excel(name = "发送方式")
    private Integer sendType;

    /** 最下数量 */
    @Excel(name = "最下数量")
    private Double minAmount;

    /** 最大数量 */
    @Excel(name = "最大数量")
    private Double maxAmount;

    /** 发放开始时间 */
    @Excel(name = "发放开始时间")
    private Long sendStartDate;

    /** 发放结束时间 */
    @Excel(name = "发放结束时间")
    private Long sendEndDate;

    /** 有效起始时间 */
    @Excel(name = "有效起始时间")
    private Long useStartDate;

    /** 有效截止日期 */
    @Excel(name = "有效截止日期")
    private Long useEndDate;

    /** 数量 */
    @Excel(name = "数量")
    private Double minGoodsAmount;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setTypeMoney(Double typeMoney)
    {
        this.typeMoney = typeMoney;
    }

    public Double getTypeMoney()
    {
        return typeMoney;
    }
    public void setSendType(Integer sendType)
    {
        this.sendType = sendType;
    }

    public Integer getSendType()
    {
        return sendType;
    }
    public void setMinAmount(Double minAmount)
    {
        this.minAmount = minAmount;
    }

    public Double getMinAmount()
    {
        return minAmount;
    }
    public void setMaxAmount(Double maxAmount)
    {
        this.maxAmount = maxAmount;
    }

    public Double getMaxAmount()
    {
        return maxAmount;
    }
    public void setSendStartDate(Long sendStartDate)
    {
        this.sendStartDate = sendStartDate;
    }

    public Long getSendStartDate()
    {
        return sendStartDate;
    }
    public void setSendEndDate(Long sendEndDate)
    {
        this.sendEndDate = sendEndDate;
    }

    public Long getSendEndDate()
    {
        return sendEndDate;
    }
    public void setUseStartDate(Long useStartDate)
    {
        this.useStartDate = useStartDate;
    }

    public Long getUseStartDate()
    {
        return useStartDate;
    }
    public void setUseEndDate(Long useEndDate)
    {
        this.useEndDate = useEndDate;
    }

    public Long getUseEndDate()
    {
        return useEndDate;
    }
    public void setMinGoodsAmount(Double minGoodsAmount)
    {
        this.minGoodsAmount = minGoodsAmount;
    }

    public Double getMinGoodsAmount()
    {
        return minGoodsAmount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("typeMoney", getTypeMoney())
            .append("sendType", getSendType())
            .append("minAmount", getMinAmount())
            .append("maxAmount", getMaxAmount())
            .append("sendStartDate", getSendStartDate())
            .append("sendEndDate", getSendEndDate())
            .append("useStartDate", getUseStartDate())
            .append("useEndDate", getUseEndDate())
            .append("minGoodsAmount", getMinGoodsAmount())
            .toString();
    }
}
