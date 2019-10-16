package com.newland.nideshopserver.config;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author xzt
 * @create 2019-09-29 14:15
 * 通用mapper框架使用的基本mapper类
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
    // 111
}
