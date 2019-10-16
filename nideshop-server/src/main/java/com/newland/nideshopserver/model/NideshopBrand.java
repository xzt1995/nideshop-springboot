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
@Table(name = "nideshop_brand")
public class NideshopBrand {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String name;
    private String listPicUrl;
    private String simpleDesc;
    private String picUrl;
    private Integer sortOrder;
    private Integer isShow;
    private Integer floorPrice;
    private String appListPicUrl;
    private Integer isNew;
    private String newPicUrl;
    private Integer newSortOrder;

}
