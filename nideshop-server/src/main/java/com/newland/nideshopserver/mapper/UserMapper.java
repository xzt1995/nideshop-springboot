package com.newland.nideshopserver.mapper;

import com.newland.nideshopserver.config.MyMapper;
import com.newland.nideshopserver.model.NideshopUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author xzt
 * @create 2019-10-15 16:34
 */
@Mapper
@Repository
public interface UserMapper extends MyMapper<NideshopUser> {

}
