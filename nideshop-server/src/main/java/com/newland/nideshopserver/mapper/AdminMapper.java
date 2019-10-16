package com.newland.nideshopserver.mapper;

import com.newland.nideshopserver.config.MyMapper;
import com.newland.nideshopserver.model.NideshopAdmin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author xzt
 * @create 2019-09-29 15:07
 */
@Mapper
public interface AdminMapper extends MyMapper<NideshopAdmin> {
}
