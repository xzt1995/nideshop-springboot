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

	@Select("SELECT COUNT(`nideshop_topic`.id) AS think_count FROM `nideshop_topic` LIMIT 1")
	int topicCount();

	@Select("SELECT `id`,`title`,price_info as 'priceInfo',scene_pic_url as 'scenePicUrl',`subtitle` FROM `nideshop_topic` LIMIT #{begin},#{end}")
	List<NideshopTopic> selectTopic(@Param("begin") int begin, @Param("end") int end);

	@Select("SELECT `id`,`title`,price_info as 'priceInfo',scene_pic_url as 'scenePicUrl',`subtitle` FROM `nideshop_topic` LIMIT #{num}")
	List<NideshopTopic> relatedTopic(int num);
}
