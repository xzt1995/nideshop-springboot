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
 * @CREATE2019-09-29 12:23
 */
@Getter
@Setter
@ToString
@Table(name = "nideshop_goods")
public class NideshopGoods {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private Integer categoryId;
    private String goodsSn;
    private String name;
    private Integer brandId;
    private Integer goodsNumber;
    private String keywords;
    private String goodsBrief;
    private String goodsDesc;
    private Integer isOnSale;
    private Integer addTime;
    private Integer sortOrder;
    private Integer isDelete;
    private Integer attributeCategory;
    private Integer counterPrice;
    private Integer extraPrice;
    private Integer isNew;
    private String goodsUnit;
    private String primaryPicUrl;
    private String listPicUrl;
    private Integer retailPrice;
    private Integer sellVolume;
    private Integer primaryProductId;
    private Integer unitPrice;
    private String promotionDesc;
    private String promotionTag;
    private Integer appExclusivePrice;
    private Integer isAppExclusive;
    private Integer isLimited;
    private Integer isHot;

}
