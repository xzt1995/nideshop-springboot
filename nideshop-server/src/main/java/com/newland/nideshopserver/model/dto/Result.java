package com.newland.nideshopserver.model.dto;

import lombok.Data;

import java.util.Map;

/**
 * @author xzt
 * @CREATE2019-10-11 14:58
 * 与小程序前端交互的数据格式
 */
@Data
public class Result {
    private Object data;
    private Integer errno = 0;
    private String errmsg = "";
}
