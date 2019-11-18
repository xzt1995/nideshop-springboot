package com.newland.nideshopserver.model.dto;

import java.io.Serializable;

/**
 * @author xzt
 * @CREATE2019-10-28 10:03
 * 响应码
 */
public enum ResultCode implements Serializable {
    /** 成功 */
    SUCCESS(200, "成功"),
    /** 发生异常 */
    EXCEPTION(500, "发生异常"),
    NO_AUTH(401,"请登录后再尝试"),
    FORBIDDEN(403,"未认证"),
    NULL(403,"禁止"),
    NOT_BIND(1234,"请先绑定手机号"),
    NOT_FOUND(404,"未找到相应文件"),
    NO_GOODS(406,"请选择商品"),
    NO_ADDRESS(405,"请选择地址"),
    INSERT_ORDER_ERROR(407,"订单提交失败"),
    NO_ORDER(408,"没有这个订单");
    private int val;
    private String msg;

    ResultCode(int value, String msg){
        this.val = value;
        this.msg = msg;
    }

    public int val() {
        return val;
    }

    public String msg() {
        return msg;
    }


}
