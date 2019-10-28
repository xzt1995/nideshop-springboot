package com.newland.nideshopserver.service;

import com.newland.nideshopserver.model.NideshopComment;
import com.newland.nideshopserver.model.dto.Comment;
import com.newland.nideshopserver.model.dto.CountSelect;

/**
 * @author xzt
 * @create 2019-10-15 14:17
 */
public interface CommentService {
    /**
     * 显示专题评论
     * @param typeId 类型
     * @param valueId 对应的topic 的ID
     * @param showType 选择显示评论的类型 0 全部， 1 只显示有图片的评论
     * @param page 页数
     * @param size 每页数量
     * @return
     */
    CountSelect listService(int typeId, int valueId, int size) throws Exception;


    /**
     * 显示所有评论数量
     * @param typeId
     * @param valueId
     * @return
     */
    int allCount(int typeId , int valueId);

    /**
     * 显示带图片评论数量
     * @param typeId
     * @param valueId
     * @return
     */
    int picCount(int typeId , int valueId);


	/**
	 * 查看热门评论
	 * @param typeId
	 * @param valueId
	 * @return
	 */
	NideshopComment getHotCommentByGoodsId(int typeId,int  valueId);


	/**
	 * 评论信息
	 * @param hotComment
	 * @return
	 */
	Comment getCommentInfo(NideshopComment hotComment);
    

}
