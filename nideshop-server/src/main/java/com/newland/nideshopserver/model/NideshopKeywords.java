package com.newland.nideshopserver.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author xzt
 * @CREATE2019-09-29 12:24
 */
@Getter
@Setter
@ToString
@Table(name = "nideshop_keywords")
public class NideshopKeywords {

    private String keyword;
    private Integer isHot;
    private Integer isDefault;
    private Integer isShow;
    private Integer sortOrder;
    private String schemeUrl;
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private Integer type;

}
