package com.xinqian.cms.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xinqian.cms.domain.Comment;
import com.xinqian.cms.domain.User;
import com.xinqian.cms.service.CommentService;
@RequestMapping("comment")
@Controller
public class CommentController {
	@Autowired
	private CommentService commentService;
	@ResponseBody
	@RequestMapping("addComment")
	public Object addComment(Comment comment,HttpSession session) {
		User user = (User) session.getAttribute("user");
		comment.setUser(user);
		//获得系统当前时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();
		comment.setCreated(sdf.format(date));
		int result = commentService.addComment(comment);
		return result;
	}
}
