package com.newland.nideshopserver.model.dto;

import com.newland.nideshopserver.model.NideshopUser;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xzt
 * @CREATE2019-10-28 15:21
 * 前端登录参数
 */
@Data
public class UserInfo implements Serializable {
    private String encryptedData;
    private String errMsg;
    private String iv;
    private String rawData;
    private String signature;
    private NideshopUser userInfo;
}
