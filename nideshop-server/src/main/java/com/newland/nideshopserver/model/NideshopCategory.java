package com.newland.nideshopserver.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author xzt
 * @CREATE2019-09-29 12:23
 */
@Getter
@Setter
@ToString
@Table(name = "nideshop_category")
public class NideshopCategory {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String name;
    private String keywords;
    private String frontDesc;
    private Integer parentId;
    private Integer sortOrder;
    private Integer showIndex;
    private Integer isShow;
    private String bannerUrl;
    private String iconUrl;
    private String imgUrl;
    private String wapBannerUrl;
    private String level;
    private Integer type;
    private String frontName;
}
