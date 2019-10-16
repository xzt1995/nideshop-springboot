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
@Table(name = "nideshop_feedback")
public class NideshopFeedback {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer msgId;
    private Integer parentId;
    private Integer userId;
    private String userName;
    private String userEmail;
    private String msgTitle;
    private Integer msgType;
    private Integer msgStatus;
    private String msgContent;
    private Integer msgTime;
    private String messageImg;
    private Integer orderId;
    private Byte msgArea;

}
