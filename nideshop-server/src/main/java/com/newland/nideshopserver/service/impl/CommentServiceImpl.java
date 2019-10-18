package com.newland.nideshopserver.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newland.nideshopserver.mapper.CommentMapper;
import com.newland.nideshopserver.mapper.CommentPictureMapper;
import com.newland.nideshopserver.mapper.UserMapper;
import com.newland.nideshopserver.model.NideshopComment;
import com.newland.nideshopserver.model.NideshopCommentPicture;
import com.newland.nideshopserver.model.NideshopUser;
import com.newland.nideshopserver.model.dto.Comment;
import com.newland.nideshopserver.model.dto.CountSelect;
import com.newland.nideshopserver.service.CommentService;
import com.newland.nideshopserver.utis.Utis;

import tk.mybatis.mapper.entity.Example;

/**
 * @author xzt @CREATE2019-10-15 14:17
 */
@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentMapper commentMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private CommentPictureMapper commentPictureMapper;

	@Override
	public CountSelect listService(int typeId, int valueId, int size) throws Exception {
		// page = (page > 0 ) ? page : 1 ;
		size = (size > 0) ? size : 20;
		// showType = (showType > 0 ) ? showType : 0 ;
		int page = 1;
		int showType = 0;
		List<NideshopComment> commentList = null;
		// 当前topic评论总数
		int count = 0;
		if (showType == 0) {
			// 全部评论数量
			count = commentMapper.commentCount(typeId, valueId);
			// 查询TOPIC所有评论数据（取前size个）
			Example e = new Example(NideshopComment.class);
			Example.Criteria c = e.createCriteria();
			c.andEqualTo("typeId", typeId);
			c.andEqualTo("valueId", valueId);
			List<NideshopComment> comments = commentMapper.selectByExample(e);
			if (comments != null) {
				commentList = comments.subList(0, size);
			}
		} else {
			// 带图片评论数量
			count = commentMapper.joinCommentCount(typeId, valueId);
			commentList = commentMapper.picComment(typeId, valueId, page, size);
		}
		ArrayList<Comment> list = new ArrayList<>();
		if (commentList != null) {
			for (NideshopComment c : commentList) {
				Comment comment = new Comment();
				// base64 解码
				String content = Utis.base64Decoder(c.getContent());
				comment.setContent(content);
				comment.setTypeId(c.getTypeId());
				comment.setValueId(c.getValueId());
				comment.setId(c.getId());
				// 时间转码
				comment.setAddTime(Utis.timeFormat(c.getAddTime()));
				// 查询该条评论用户的信息
				Example e = new Example(NideshopUser.class);
				e.selectProperties("username", "avatar", "nickname");
				Example.Criteria criteria = e.createCriteria();
				criteria.andEqualTo("id", c.getUserId());
				NideshopUser user = userMapper.selectOneByExample(e);
				comment.setUserInfo(user);
				// 查询评论图片信息
				Example e1 = new Example(NideshopCommentPicture.class);
				e1.createCriteria().andEqualTo("commentId", c.getId());
				List<NideshopCommentPicture> pictures = commentPictureMapper.selectByExample(e1);
				comment.setPicList(pictures);
				list.add(comment);
			}
		}
		// 分页总页数
		int totalPages = Utis.totalPages(count, size);
		CountSelect countSelect = new CountSelect();
		countSelect.setData(list);
		countSelect.setCount(count);
		countSelect.setCurrentPage(page);
		countSelect.setPageSize(size);
		countSelect.setTotalPages(totalPages);
		return countSelect;
	}

	@Override
	public int allCount(int typeId, int valueId) {
		int count = commentMapper.commentCount(typeId, valueId);
		return count;
	}

	@Override
	public int picCount(int typeId, int valueId) {
		int count = commentMapper.joinCommentCount(typeId, valueId);
		return count;
	}

	@Override
	public NideshopComment getHotCommentByGoodsId(int typeId, int valueId) {
		NideshopComment record = new NideshopComment();
		record.setValueId(valueId);
		record.setTypeId(typeId);

		return commentMapper.selectOne(record);
	}

	@Override
	public Comment getCommentInfo(NideshopComment hotComment) {
		
		if(hotComment==null) {
			return null;
		}
		
		Comment comment = new Comment();
		NideshopUser user = new NideshopUser();
		user.setId(hotComment.getUserId());
		NideshopUser user2 = userMapper.selectOne(user);
	
		
		try {
			comment.setContent(Utis.base64Decoder(hotComment.getContent()));
		} catch (Exception e) {
			//TODO log err
		}
		comment.setAddTime(new Date(hotComment.getAddTime()*1000).toString());
		comment.setNikename(user2.getNickname());
		comment.setAvatar(user2.getAvatar());
		
		NideshopCommentPicture pic=new NideshopCommentPicture();
		pic.setCommentId(hotComment.getId());
		List<NideshopCommentPicture> picList = commentPictureMapper.select(pic);
		
		comment.setPicList(picList);
		
		return comment;
	}

}
