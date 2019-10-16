package com.newland.nideshopserver.model.dto;

import com.newland.nideshopserver.model.NideshopGoods;
import lombok.Data;

import java.util.List;

/**
 * @author xzt
 * @CREATE2019-10-11 14:01
 */
@Data
public class CategoryList {
    private int id;
    private String name;
    private List<NideshopGoods> goodsList;
}
