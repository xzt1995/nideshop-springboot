package com.newland.nideshopserver.model;

import lombok.*;
import tk.mybatis.mapper.annotation.KeySql;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author xzt
 * @CREATE2019-09-29 12:23
 */
@Getter
@Setter
@ToString
@Table(name = "nideshop_ad")
public class NideshopAd {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private Integer adPositionId;
    private Byte mediaType;
    private String name;
    private String link;
    private String imageUrl;
    private String content;
    private Integer endTime;
    private Byte enabled;

}
