package com.newland.nideshopserver.mapper;

import com.newland.nideshopserver.config.MyMapper;
import com.newland.nideshopserver.model.NideshopComment;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author xzt
 * @CREATE2019-10-15 10:16
 */
@Repository
public interface CommentMapper extends MyMapper<NideshopComment> {

    /**
     * 专题评论总数
     * @param type
     * @param value
     * @return
     */
    @Select(" SELECT COUNT(`nideshop_comment`.id) FROM `nideshop_comment` WHERE ( `type_id` = #{type} ) AND ( `value_id` = #{value} ) ")
    int commentCount(@Param("type") int type,@Param("value") int value);

    /**
     * 只看带图评论数量
     * @param typeID
     * @param valueId
     * @return
     */
    @Select("select count(*) from `nideshop_comment` RIGHT JOIN `nideshop_comment_picture` on `nideshop_comment`.`id` = `nideshop_comment_picture`.`comment_id` WHERE ( `type_id` = #{typeId} ) AND ( `value_id` = #{valueId} ) LIMIT 1 ")
    int joinCommentCount(@Param("typeId")int typeId,@Param("valueId") int valueId);


    /**
     * 所有带图片的评论
     * @return
     */
    @Select("select id , type_id as 'typeId' , value_id as 'valueId' , content , add_time as 'addTime' ,status , user_id as 'userId' , new_content as 'newContent' from 'nideshop_comment' where id in (select count(*) from `nideshop_comment` RIGHT JOIN `nideshop_comment_picture` on `nideshop_comment`.`id` = `nideshop_comment_picture`.`comment_id` WHERE ( `type_id` = #{typeId} ) AND ( `value_id` = #{valueId} ) LIMIT #{begin},#{end} )")
    List<NideshopComment> picComment(int typeID, int valueId ,int begin , int end);
}
