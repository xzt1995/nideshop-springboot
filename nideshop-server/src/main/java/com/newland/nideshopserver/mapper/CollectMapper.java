/**
 * @Description:    TODO(用一句话描述该文件做什么)
 * @author: wangzb
 * @date:   2019年10月17日 下午3:09:32
 * @version V1.0
 */
package com.newland.nideshopserver.mapper;

import com.newland.nideshopserver.config.MyMapper;
import com.newland.nideshopserver.model.NideshopCollect;
import com.newland.nideshopserver.model.NideshopGoods;
import com.newland.nideshopserver.model.dto.CollectGoods;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:    TODO(用一句话描述该文件做什么)
 * @author: wangzb
 * @date:   2019年10月17日 下午3:09:32
 * @version V1.0
 */
@Repository
public interface CollectMapper extends MyMapper<NideshopCollect> {

    @Select("SELECT COUNT(`c`.id) AS think_count FROM `nideshop_collect` AS c LEFT JOIN `nideshop_goods` AS `g` ON c.value_id = g.id WHERE ( `user_id` = #{userId} ) AND ( `type_id` = #{typeId} ) LIMIT 1")
    int listCount(int typeId , int userId);

    @Select(" SELECT c.id , c.user_id as userId , c.value_id as valueId , c.add_time as addTime , c.is_attention as isAttention , c.type_id as typeId,g.name, g.list_pic_url as listPicUrl ,g.goods_brief as goodsBrief,g.retail_price as retailPrice FROM `nideshop_collect` AS c LEFT JOIN `nideshop_goods` AS `g` ON c.value_id = g.id WHERE ( `user_id` = #{userId}  ) AND ( `type_id` = #{typeId}  )")
    List<CollectGoods> listAll(int typeId , int userId);
}
