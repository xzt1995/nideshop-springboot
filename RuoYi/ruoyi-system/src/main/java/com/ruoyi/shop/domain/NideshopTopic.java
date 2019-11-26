package com.ruoyi.shop.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品专题对象 nideshop_topic
 *
 * @author ruoyi
 * @date 2019-11-26
 */
public class NideshopTopic extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id*/
    private Integer id;

    /** 标题 */
    @Excel(name = "标题", readConverterExp = "$column.readConverterExp()")
    private String title;

    /** 内容 */
    @Excel(name = "内容", readConverterExp = "$column.readConverterExp()")
    private String content;

    /** 头像图片链接 */
    @Excel(name = "头像图片链接", readConverterExp = "$column.readConverterExp()")
    private String avatar;

    /** 项目图片 */
    @Excel(name = "项目图片", readConverterExp = "$column.readConverterExp()")
    private String itemPicUrl;

    /** 项目简介 */
    @Excel(name = "项目简介", readConverterExp = "$column.readConverterExp()")
    private String subtitle;

//    /** $column.columnComment */
//    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long topicCategoryId;

    /** 价格信息 */
    @Excel(name = "价格信息", readConverterExp = "$column.readConverterExp()")
    private Double priceInfo;

    /** 点击次数 */
    @Excel(name = "点击次数", readConverterExp = "$column.readConverterExp()")
    private String readCount;

    /** 场景图片网址 */
    @Excel(name = "场景图片网址", readConverterExp = "$column.readConverterExp()")
    private String scenePicUrl;

    /** 主题模板ID */
   // @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long topicTemplateId;

//    /** $column.columnComment */
//    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long topicTagId;

//    /** $column.columnComment */
//    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long sortOrder;

//    /** $column.columnComment */
//    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer isShow;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }
    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }

    public String getAvatar()
    {
        return avatar;
    }
    public void setItemPicUrl(String itemPicUrl)
    {
        this.itemPicUrl = itemPicUrl;
    }

    public String getItemPicUrl()
    {
        return itemPicUrl;
    }
    public void setSubtitle(String subtitle)
    {
        this.subtitle = subtitle;
    }

    public String getSubtitle()
    {
        return subtitle;
    }
    public void setTopicCategoryId(Long topicCategoryId)
    {
        this.topicCategoryId = topicCategoryId;
    }

    public Long getTopicCategoryId()
    {
        return topicCategoryId;
    }
    public void setPriceInfo(Double priceInfo)
    {
        this.priceInfo = priceInfo;
    }

    public Double getPriceInfo()
    {
        return priceInfo;
    }
    public void setReadCount(String readCount)
    {
        this.readCount = readCount;
    }

    public String getReadCount()
    {
        return readCount;
    }
    public void setScenePicUrl(String scenePicUrl)
    {
        this.scenePicUrl = scenePicUrl;
    }

    public String getScenePicUrl()
    {
        return scenePicUrl;
    }
    public void setTopicTemplateId(Long topicTemplateId)
    {
        this.topicTemplateId = topicTemplateId;
    }

    public Long getTopicTemplateId()
    {
        return topicTemplateId;
    }
    public void setTopicTagId(Long topicTagId)
    {
        this.topicTagId = topicTagId;
    }

    public Long getTopicTagId()
    {
        return topicTagId;
    }
    public void setSortOrder(Long sortOrder)
    {
        this.sortOrder = sortOrder;
    }

    public Long getSortOrder()
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("content", getContent())
            .append("avatar", getAvatar())
            .append("itemPicUrl", getItemPicUrl())
            .append("subtitle", getSubtitle())
            .append("topicCategoryId", getTopicCategoryId())
            .append("priceInfo", getPriceInfo())
            .append("readCount", getReadCount())
            .append("scenePicUrl", getScenePicUrl())
            .append("topicTemplateId", getTopicTemplateId())
            .append("topicTagId", getTopicTagId())
            .append("sortOrder", getSortOrder())
            .append("isShow", getIsShow())
            .toString();
    }
}
