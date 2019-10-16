package com.newland.nideshopserver.mapper;

import com.newland.nideshopserver.config.MyMapper;
import com.newland.nideshopserver.model.NideshopChannel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
 * @author xzt
 * @create 2019-10-11 10:29
 */
@Repository
public interface ChannelMapper extends MyMapper<NideshopChannel> {


}
