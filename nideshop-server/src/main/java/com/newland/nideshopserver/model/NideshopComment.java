package com.newland.nideshopserver.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tk.mybatis.mapper.annotation.KeySql;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * @author xzt
 * @CREATE2019-09-29 12:23
 */
@Getter
@Setter
@ToString
@Table(name = "nideshop_comment")
public class NideshopComment {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private Integer typeId;
    private Integer valueId;
    private String content;
    private Long addTime;
    private Integer status;
    private Integer userId;
    private String newContent;
}
