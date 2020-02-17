package com.xinqian.cms.service.impl;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bw.utils.RandomUtil;
import com.xinqian.cms.domain.Article;
import com.xinqian.cms.domain.Comment;
import com.xinqian.cms.domain.User;
import com.xinqian.cms.service.CommentService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class CommentServiceImplTest {
	@Autowired
	private CommentService commentService;
	@Test
	public void testAddComment() {
		User user = new User();
		user.setId(131);
		for (int i = 0; i < 1000; i++) {
			Comment comment = new Comment();
			//添加装入模拟用户
			comment.setUser(user);
			//文章Id需要在10个以上分配
			Article article = new Article();
			//如何随机获得文章的id
			article.setId(RandomUtil.getRandomNum(24,32));
			comment.setArticle(article);
			//评论内容需要用随机字符串生成，最少100字
			String content = RandomUtil.getRandomChineseString(RandomUtil.getRandomNum(100,200));
			comment.setContent(content);
			//发布时间从2019-1-1 00:00:00 至今随机
			//获得2019-1-1 long类型的毫秒值
			Calendar calendar = Calendar.getInstance();
			calendar.set(2019,0,1,0,0,0);
			//2019-1-1的ms值
			long time1 = calendar.getTime().getTime();
			//获得当前时间的ms值
			long time2 = new Date().getTime();
			//从时间差中随机获取时间
			long time=(long)(Math.random()*(time2-time1))+time1;
			Date date = new Date();
			date.setTime(time);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			comment.setCreated(sdf.format(date));
			//执行添加
			commentService.addComment(comment);
		}
		
	}

	@Test
	public void testSelectComments() {
		fail("Not yet implemented");
	}

}
