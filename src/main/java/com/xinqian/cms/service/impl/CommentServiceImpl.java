package com.xinqian.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xinqian.cms.dao.CommentDao;
import com.xinqian.cms.domain.Comment;
import com.xinqian.cms.service.CommentService;
@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	private CommentDao commentDao;
	@Override
	public int addComment(Comment comment) {
		// TODO Auto-generated method stub
		return commentDao.addComment(comment);
	}

	@Override
	public PageInfo<Comment> selectComments(Integer id,Integer pageNum,Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<Comment> list = commentDao.selectComments(id);
		return new PageInfo<Comment>(list);
	}

}
