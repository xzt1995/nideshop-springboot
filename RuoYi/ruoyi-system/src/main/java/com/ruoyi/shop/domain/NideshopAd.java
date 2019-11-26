package com.ruoyi.shop.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 首页轮播广告对象 nideshop_ad
 *
 * @author ruoyi
 * @date 2019-11-26
 */
public class NideshopAd extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Integer id;

    /** adPositionId */
    @Excel(name = "adPositionId", readConverterExp = "$column.readConverterExp()")
    private Integer adPositionId;

    /** 类型 */
    @Excel(name = "类型", readConverterExp = "$column.readConverterExp()")
    private Integer mediaType;

    /** 名称 */
    @Excel(name = "名称", readConverterExp = "$column.readConverterExp()")
    private String name;

    /** link */
    @Excel(name = "link", readConverterExp = "$column.readConverterExp()")
    private String link;

    /** 图片链接 */
    @Excel(name = "图片链接", readConverterExp = "$column.readConverterExp()")
    private String imageUrl;

    /** 内容 */
    @Excel(name = "内容", readConverterExp = "$column.readConverterExp()")
    private String content;

    /** endTime*/
    @Excel(name = "endTime", readConverterExp = "$column.readConverterExp()")
    private Long endTime;

    /** enabled */
    @Excel(name = "enabled", readConverterExp = "$column.readConverterExp()")
    private Integer enabled;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setAdPositionId(Integer adPositionId)
    {
        this.adPositionId = adPositionId;
    }

    public Integer getAdPositionId()
    {
        return adPositionId;
    }
    public void setMediaType(Integer mediaType)
    {
        this.mediaType = mediaType;
    }

    public Integer getMediaType()
    {
        return mediaType;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setLink(String link)
    {
        this.link = link;
    }

    public String getLink()
    {
        return link;
    }
    public void setImageUrl(String imageUrl)
    {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }
    public void setEndTime(Long endTime)
    {
        this.endTime = endTime;
    }

    public Long getEndTime()
    {
        return endTime;
    }
    public void setEnabled(Integer enabled)
    {
        this.enabled = enabled;
    }

    public Integer getEnabled()
    {
        return enabled;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("adPositionId", getAdPositionId())
            .append("mediaType", getMediaType())
            .append("name", getName())
            .append("link", getLink())
            .append("imageUrl", getImageUrl())
            .append("content", getContent())
            .append("endTime", getEndTime())
            .append("enabled", getEnabled())
            .toString();
    }
}
