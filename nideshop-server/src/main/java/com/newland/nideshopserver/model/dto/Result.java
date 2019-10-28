package com.newland.nideshopserver.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author xzt
 * @CREATE2019-10-11 14:58
 * 与小程序前端交互的数据格式
 */
@Data

public class Result implements Serializable {
    private Object data;
    private Integer errno = 0;
    private String errmsg = "";
    public static Result build(Integer errno, String errmsg,Object data) {
        return new Result(errno, errmsg,null);
    }
    public Result(Integer errno, String errmsg,Object data) {
        this.data = data;
        this.errno = errno;
        this.errmsg = errmsg;
    }
    public Result() {
    }
}
