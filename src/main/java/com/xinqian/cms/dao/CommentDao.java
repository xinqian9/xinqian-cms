package com.xinqian.cms.dao;

import java.util.List;

import com.xinqian.cms.domain.Comment;

public interface CommentDao {
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
	 * @return
	 * @return: List<Comment>
	 */
	public List<Comment> selectComments(Integer id);
}
