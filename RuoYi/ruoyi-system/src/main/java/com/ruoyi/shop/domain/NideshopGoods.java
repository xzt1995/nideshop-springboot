package com.ruoyi.shop.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品信息对象 nideshop_goods
 *
 * @author ruoyi
 * @date 2019-11-29
 */
public class NideshopGoods extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 商品分类ID */
    @Excel(name = "商品分类ID")
    private Long categoryId;

    /** 商品sn号 */
    @Excel(name = "商品sn号")
    private String goodsSn;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 品牌ID */
    @Excel(name = "品牌ID")
    private Long brandId;

    /** 商品数量 */
    @Excel(name = "商品数量")
    private Integer goodsNumber;

    /** 关键字 */
    @Excel(name = "关键字")
    private String keywords;

    /** 商品简介 */
    @Excel(name = "商品简介")
    private String goodsBrief;

    /** 商品描述 */
    @Excel(name = "商品描述")
    private String goodsDesc;

    /** 是否上架 */
    @Excel(name = "是否上架")
    private Integer isOnSale;

    /** 添加时间 */
    @Excel(name = "添加时间")
    private Integer addTime;

    /** 排序 */
    @Excel(name = "排序")
    private Integer sortOrder;

    /** 是否删除 */
    @Excel(name = "是否删除")
    private Integer isDelete;

    /** 属性类别 */
    @Excel(name = "属性类别")
    private Long attributeCategory;

    /** 专柜价格 */
    @Excel(name = "专柜价格")
    private Double counterPrice;

    /** 附加价格 */
    @Excel(name = "附加价格")
    private Double extraPrice;

    /** 是否新品 */
    @Excel(name = "是否新品")
    private Integer isNew;

    /** 商品单位 */
    @Excel(name = "商品单位")
    private String goodsUnit;

    /** 商品主图 */
    @Excel(name = "商品主图")
    private String primaryPicUrl;

    /** 商品列表图 */
    @Excel(name = "商品列表图")
    private String listPicUrl;

    /** 零售价格 */
    @Excel(name = "零售价格")
    private Double retailPrice;

    /** 销售量 */
    @Excel(name = "销售量")
    private Long sellVolume;

    /** 主sku　product_id */
    @Excel(name = "主sku　product_id")
    private Long primaryProductId;

    /** 单位价格，单价 */
    @Excel(name = "单位价格，单价")
    private Double unitPrice;

    /** 促销说明 */
    @Excel(name = "促销说明")
    private String promotionDesc;

    /** 促销标志 */
    @Excel(name = "促销标志")
    private String promotionTag;

    /** APP专享价 */
    @Excel(name = "APP专享价")
    private Double appExclusivePrice;

    /** 是否是APP专属 */
    @Excel(name = "是否是APP专属")
    private Integer isAppExclusive;

    /** 是否限制 */
    @Excel(name = "是否限制")
    private Integer isLimited;

    /** 是否热门 */
    @Excel(name = "是否热门")
    private Integer isHot;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setCategoryId(Long categoryId)
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId()
    {
        return categoryId;
    }
    public void setGoodsSn(String goodsSn)
    {
        this.goodsSn = goodsSn;
    }

    public String getGoodsSn()
    {
        return goodsSn;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setBrandId(Long brandId)
    {
        this.brandId = brandId;
    }

    public Long getBrandId()
    {
        return brandId;
    }
    public void setGoodsNumber(Integer goodsNumber)
    {
        this.goodsNumber = goodsNumber;
    }

    public Integer getGoodsNumber()
    {
        return goodsNumber;
    }
    public void setKeywords(String keywords)
    {
        this.keywords = keywords;
    }

    public String getKeywords()
    {
        return keywords;
    }
    public void setGoodsBrief(String goodsBrief)
    {
        this.goodsBrief = goodsBrief;
    }

    public String getGoodsBrief()
    {
        return goodsBrief;
    }
    public void setGoodsDesc(String goodsDesc)
    {
        this.goodsDesc = goodsDesc;
    }

    public String getGoodsDesc()
    {
        return goodsDesc;
    }
    public void setIsOnSale(Integer isOnSale)
    {
        this.isOnSale = isOnSale;
    }

    public Integer getIsOnSale()
    {
        return isOnSale;
    }
    public void setAddTime(Integer addTime)
    {
        this.addTime = addTime;
    }

    public Integer getAddTime()
    {
        return addTime;
    }
    public void setSortOrder(Integer sortOrder)
    {
        this.sortOrder = sortOrder;
    }

    public Integer getSortOrder()
    {
        return sortOrder;
    }
    public void setIsDelete(Integer isDelete)
    {
        this.isDelete = isDelete;
    }

    public Integer getIsDelete()
    {
        return isDelete;
    }
    public void setAttributeCategory(Long attributeCategory)
    {
        this.attributeCategory = attributeCategory;
    }

    public Long getAttributeCategory()
    {
        return attributeCategory;
    }
    public void setCounterPrice(Double counterPrice)
    {
        this.counterPrice = counterPrice;
    }

    public Double getCounterPrice()
    {
        return counterPrice;
    }
    public void setExtraPrice(Double extraPrice)
    {
        this.extraPrice = extraPrice;
    }

    public Double getExtraPrice()
    {
        return extraPrice;
    }
    public void setIsNew(Integer isNew)
    {
        this.isNew = isNew;
    }

    public Integer getIsNew()
    {
        return isNew;
    }
    public void setGoodsUnit(String goodsUnit)
    {
        this.goodsUnit = goodsUnit;
    }

    public String getGoodsUnit()
    {
        return goodsUnit;
    }
    public void setPrimaryPicUrl(String primaryPicUrl)
    {
        this.primaryPicUrl = primaryPicUrl;
    }

    public String getPrimaryPicUrl()
    {
        return primaryPicUrl;
    }
    public void setListPicUrl(String listPicUrl)
    {
        this.listPicUrl = listPicUrl;
    }

    public String getListPicUrl()
    {
        return listPicUrl;
    }
    public void setRetailPrice(Double retailPrice)
    {
        this.retailPrice = retailPrice;
    }

    public Double getRetailPrice()
    {
        return retailPrice;
    }
    public void setSellVolume(Long sellVolume)
    {
        this.sellVolume = sellVolume;
    }

    public Long getSellVolume()
    {
        return sellVolume;
    }
    public void setPrimaryProductId(Long primaryProductId)
    {
        this.primaryProductId = primaryProductId;
    }

    public Long getPrimaryProductId()
    {
        return primaryProductId;
    }
    public void setUnitPrice(Double unitPrice)
    {
        this.unitPrice = unitPrice;
    }

    public Double getUnitPrice()
    {
        return unitPrice;
    }
    public void setPromotionDesc(String promotionDesc)
    {
        this.promotionDesc = promotionDesc;
    }

    public String getPromotionDesc()
    {
        return promotionDesc;
    }
    public void setPromotionTag(String promotionTag)
    {
        this.promotionTag = promotionTag;
    }

    public String getPromotionTag()
    {
        return promotionTag;
    }
    public void setAppExclusivePrice(Double appExclusivePrice)
    {
        this.appExclusivePrice = appExclusivePrice;
    }

    public Double getAppExclusivePrice()
    {
        return appExclusivePrice;
    }
    public void setIsAppExclusive(Integer isAppExclusive)
    {
        this.isAppExclusive = isAppExclusive;
    }

    public Integer getIsAppExclusive()
    {
        return isAppExclusive;
    }
    public void setIsLimited(Integer isLimited)
    {
        this.isLimited = isLimited;
    }

    public Integer getIsLimited()
    {
        return isLimited;
    }
    public void setIsHot(Integer isHot)
    {
        this.isHot = isHot;
    }

    public Integer getIsHot()
    {
        return isHot;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("categoryId", getCategoryId())
            .append("goodsSn", getGoodsSn())
            .append("name", getName())
            .append("brandId", getBrandId())
            .append("goodsNumber", getGoodsNumber())
            .append("keywords", getKeywords())
            .append("goodsBrief", getGoodsBrief())
            .append("goodsDesc", getGoodsDesc())
            .append("isOnSale", getIsOnSale())
            .append("addTime", getAddTime())
            .append("sortOrder", getSortOrder())
            .append("isDelete", getIsDelete())
            .append("attributeCategory", getAttributeCategory())
            .append("counterPrice", getCounterPrice())
            .append("extraPrice", getExtraPrice())
            .append("isNew", getIsNew())
            .append("goodsUnit", getGoodsUnit())
            .append("primaryPicUrl", getPrimaryPicUrl())
            .append("listPicUrl", getListPicUrl())
            .append("retailPrice", getRetailPrice())
            .append("sellVolume", getSellVolume())
            .append("primaryProductId", getPrimaryProductId())
            .append("unitPrice", getUnitPrice())
            .append("promotionDesc", getPromotionDesc())
            .append("promotionTag", getPromotionTag())
            .append("appExclusivePrice", getAppExclusivePrice())
            .append("isAppExclusive", getIsAppExclusive())
            .append("isLimited", getIsLimited())
            .append("isHot", getIsHot())
            .toString();
    }
}
