package com.xinqian.cms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.xinqian.cms.domain.Comment;

public interface CommentService {
	/**
	 * 
	 * @Title: addComment 
	 * @Description: 添加评论
	 * @param comment
	 * @return
	 * @return: int
	 */
	public int addComment(Comment comment);
	/**
	 * 
	 * @Title: selectComments 
	 * @Description: 根据文章id查询文章评论
	 * @param id
	 * @param pageSize 
	 * @param pageNum 
	 * @return
	 * @return: List<Comment>
	 */
	public PageInfo<Comment> selectComments(Integer id, Integer pageNum, Integer pageSize);
}
