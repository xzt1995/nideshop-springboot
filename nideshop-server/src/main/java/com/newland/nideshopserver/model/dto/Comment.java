package com.newland.nideshopserver.model.dto;


import com.newland.nideshopserver.model.NideshopCommentPicture;
import com.newland.nideshopserver.model.NideshopUser;
import lombok.Data;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * @author xzt
 * @CREATE2019-10-15 16:16
 * 用于映射评论数据到前端页面
 */
@Data
public class Comment {
    private String content;
    private int typeId;
    private int valueId;
    private int id;
    private String addTime;
    private List<NideshopCommentPicture> picList;
    private NideshopUser userInfo;
}
