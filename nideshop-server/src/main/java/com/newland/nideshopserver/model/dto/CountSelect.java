package com.newland.nideshopserver.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author xzt
 * @CREATE2019-10-14 15:32
 * 对应thinkjs中countselect方法中返回参数的格式
 */
@Data
public class CountSelect {
    // 总条数
    private int count;
    // 总页数
    @JsonProperty("totalPages")
    private int totalPages;
    // 当前页
    @JsonProperty("currentPage")
    private int currentPage;
    // 每页显示多少条
    @JsonProperty("pageSize")
    private int pageSize;
    // 具体数据
    private List data;
}
