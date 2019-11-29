package com.ruoyi.shop.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品分类对象 nideshop_category
 *
 * @author ruoyi
 * @date 2019-11-28
 */
public class NideshopCategory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 关键字 */
    @Excel(name = "关键字")
    private String keywords;

    /** 简介 */
    @Excel(name = "简介")
    private String frontDesc;

    /** 父ID */
    @Excel(name = "父ID")
    private Long parentId;

    /** 排序 */
    @Excel(name = "排序")
    private Integer sortOrder;

    /** 位置 */
    @Excel(name = "位置")
    private Integer showIndex;

    /** 是否上架 */
    @Excel(name = "是否上架")
    private Integer isShow;

    /** 图片链接 */
    @Excel(name = "图片链接")
    private String bannerUrl;

    /** 图标链接 */
    @Excel(name = "图标链接")
    private String iconUrl;

    /** 照片链接 */
    @Excel(name = "照片链接")
    private String imgUrl;

    /** $column.columnComment */
    @Excel(name = "照片链接")
    private String wapBannerUrl;

    /** 等级 */
    @Excel(name = "等级")
    private String level;

    /** 类型 */
    @Excel(name = "类型")
    private Long type;

    /** 介绍 */
    @Excel(name = "介绍")
    private String frontName;

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
    public void setKeywords(String keywords)
    {
        this.keywords = keywords;
    }

    public String getKeywords()
    {
        return keywords;
    }
    public void setFrontDesc(String frontDesc)
    {
        this.frontDesc = frontDesc;
    }

    public String getFrontDesc()
    {
        return frontDesc;
    }
    public void setParentId(Long parentId)
    {
        this.parentId = parentId;
    }

    public Long getParentId()
    {
        return parentId;
    }
    public void setSortOrder(Integer sortOrder)
    {
        this.sortOrder = sortOrder;
    }

    public Integer getSortOrder()
    {
        return sortOrder;
    }
    public void setShowIndex(Integer showIndex)
    {
        this.showIndex = showIndex;
    }

    public Integer getShowIndex()
    {
        return showIndex;
    }
    public void setIsShow(Integer isShow)
    {
        this.isShow = isShow;
    }

    public Integer getIsShow()
    {
        return isShow;
    }
    public void setBannerUrl(String bannerUrl)
    {
        this.bannerUrl = bannerUrl;
    }

    public String getBannerUrl()
    {
        return bannerUrl;
    }
    public void setIconUrl(String iconUrl)
    {
        this.iconUrl = iconUrl;
    }

    public String getIconUrl()
    {
        return iconUrl;
    }
    public void setImgUrl(String imgUrl)
    {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl()
    {
        return imgUrl;
    }
    public void setWapBannerUrl(String wapBannerUrl)
    {
        this.wapBannerUrl = wapBannerUrl;
    }

    public String getWapBannerUrl()
    {
        return wapBannerUrl;
    }
    public void setLevel(String level)
    {
        this.level = level;
    }

    public String getLevel()
    {
        return level;
    }
    public void setType(Long type)
    {
        this.type = type;
    }

    public Long getType()
    {
        return type;
    }
    public void setFrontName(String frontName)
    {
        this.frontName = frontName;
    }

    public String getFrontName()
    {
        return frontName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("keywords", getKeywords())
            .append("frontDesc", getFrontDesc())
            .append("parentId", getParentId())
            .append("sortOrder", getSortOrder())
            .append("showIndex", getShowIndex())
            .append("isShow", getIsShow())
            .append("bannerUrl", getBannerUrl())
            .append("iconUrl", getIconUrl())
            .append("imgUrl", getImgUrl())
            .append("wapBannerUrl", getWapBannerUrl())
            .append("level", getLevel())
            .append("type", getType())
            .append("frontName", getFrontName())
            .toString();
    }
}
