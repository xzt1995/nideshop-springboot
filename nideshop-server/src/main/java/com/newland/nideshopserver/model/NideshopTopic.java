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
@Table(name = "nideshop_topic")
public class NideshopTopic {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String title;
    private String content;
    private String avatar;
    private String itemPicUrl;
    private String subtitle;
    private Integer topicCategoryId;
    private BigDecimal priceInfo;
    private String readCount;
    private String scenePicUrl;
    private Integer topicTemplateId;
    private Integer topicTagId;
    private Integer sortOrder;
    private Integer isShow;

}
