package com.ruoyi.shop.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商城品牌列对象 nideshop_brand
 *
 * @author ruoyi
 * @date 2019-11-26
 */
public class NideshopBrand extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商品ID */
    private Long id;

    /** 品牌名称 */
    @Excel(name = "品牌名称", readConverterExp = "$column.readConverterExp()")
    private String name;

    /** listPicUrl */
    @Excel(name = "listPicUrl", readConverterExp = "$column.readConverterExp()")
    private String listPicUrl;

    /** 品牌简介 */
    @Excel(name = "品牌简介", readConverterExp = "$column.readConverterExp()")
    private String simpleDesc;

    /** 图片链接 */
    @Excel(name = "图片链接", readConverterExp = "$column.readConverterExp()")
    private String picUrl;

    /** sortOrder */
    @Excel(name = "sortOrder", readConverterExp = "$column.readConverterExp()")
    private Integer sortOrder;

    /** isShow */
    @Excel(name = "isShow", readConverterExp = "$column.readConverterExp()")
    private Integer isShow;

    /** 最低价*/
    @Excel(name = "最低价", readConverterExp = "$column.readConverterExp()")
    private Double floorPrice;

    /** appListPicUrl*/
    @Excel(name = "appListPicUrl", readConverterExp = "$column.readConverterExp()")
    private String appListPicUrl;

    /** isNew */
    @Excel(name = "isNew", readConverterExp = "$column.readConverterExp()")
    private Integer isNew;

    /** newPicUrl */
    @Excel(name = "newPicUrl", readConverterExp = "$column.readConverterExp()")
    private String newPicUrl;

    /** newSortOrder */
    @Excel(name = "newSortOrder", readConverterExp = "$column.readConverterExp()")
    private Integer newSortOrder;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
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
    public void setListPicUrl(String listPicUrl)
    {
        this.listPicUrl = listPicUrl;
    }

    public String getListPicUrl()
    {
        return listPicUrl;
    }
    public void setSimpleDesc(String simpleDesc)
    {
        this.simpleDesc = simpleDesc;
    }

    public String getSimpleDesc()
    {
        return simpleDesc;
    }
    public void setPicUrl(String picUrl)
    {
        this.picUrl = picUrl;
    }

    public String getPicUrl()
    {
        return picUrl;
    }
    public void setSortOrder(Integer sortOrder)
    {
        this.sortOrder = sortOrder;
    }

    public Integer getSortOrder()
    {
        return sortOrder;
    }
    public void setIsShow(Integer isShow)
    {
        this.isShow = isShow;
    }

    public Integer getIsShow()
    {
        return isShow;
    }
    public void setFloorPrice(Double floorPrice)
    {
        this.floorPrice = floorPrice;
    }

    public Double getFloorPrice()
    {
        return floorPrice;
    }
    public void setAppListPicUrl(String appListPicUrl)
    {
        this.appListPicUrl = appListPicUrl;
    }

    public String getAppListPicUrl()
    {
        return appListPicUrl;
    }
    public void setIsNew(Integer isNew)
    {
        this.isNew = isNew;
    }

    public Integer getIsNew()
    {
        return isNew;
    }
    public void setNewPicUrl(String newPicUrl)
    {
        this.newPicUrl = newPicUrl;
    }

    public String getNewPicUrl()
    {
        return newPicUrl;
    }
    public void setNewSortOrder(Integer newSortOrder)
    {
        this.newSortOrder = newSortOrder;
    }

    public Integer getNewSortOrder()
    {
        return newSortOrder;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("listPicUrl", getListPicUrl())
            .append("simpleDesc", getSimpleDesc())
            .append("picUrl", getPicUrl())
            .append("sortOrder", getSortOrder())
            .append("isShow", getIsShow())
            .append("floorPrice", getFloorPrice())
            .append("appListPicUrl", getAppListPicUrl())
            .append("isNew", getIsNew())
            .append("newPicUrl", getNewPicUrl())
            .append("newSortOrder", getNewSortOrder())
            .toString();
    }
}
