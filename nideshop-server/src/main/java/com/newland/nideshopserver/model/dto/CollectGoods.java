package com.newland.nideshopserver.model.dto;

import lombok.Data;

/**
 * @author xzt
 * @CREATE2019-11-05 15:21
 */
@Data
public class CollectGoods {
    private Integer id;
    private Integer userId;
    private Integer valueId;
    private Long addTime;
    private Integer isAttention;
    private Integer typeId;

    private String name;
    private String goodsBrief;
    private String listPicUrl;
    private Integer retailPrice;

}
