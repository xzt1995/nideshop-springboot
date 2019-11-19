package com.newland.nideshopserver.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.newland.nideshopserver.config.MyMapper;
import com.newland.nideshopserver.model.NideshopTopic;

/**
 * @author xzt
 * @create 2019-09-30 14:29
 */
@Mapper
public interface TopicMapper extends MyMapper<NideshopTopic> {

}
