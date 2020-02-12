package com.xinqian.cms.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xinqian.cms.domain.Article;
import com.xinqian.cms.service.ArticleService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class ArticleServiceImplTest {
	@Autowired
	private ArticleService service;
//	@Test
//	public void testSelectArticleByAdmin() {
//		List<Article> list = service.selectArticleByAdmin();
//		for (Article article : list) {
//			System.out.println(article);
//		}
//	}

}
