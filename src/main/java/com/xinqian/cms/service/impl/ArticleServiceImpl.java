package com.xinqian.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xinqian.cms.dao.ArticleDao;
import com.xinqian.cms.domain.Article;
import com.xinqian.cms.domain.Category;
import com.xinqian.cms.domain.Channel;
import com.xinqian.cms.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService{
	@Autowired
	private ArticleDao articleDao;

	@Override
	public PageInfo<Article> selectArticleByAdmin(Article article, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Article> list = articleDao.selectArticleByAdmin(article);
		return new PageInfo<Article>(list);
	}

	@Override
	public boolean updateArticle(Article article) {
		try {
			articleDao.updateArticle(article);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public Article selectArticleById(Integer id) {
		// TODO Auto-generated method stub
		return articleDao.selectArticleById(id);
	}

	@Override
	public List<Channel> selectChannels() {
		// TODO Auto-generated method stub
		return articleDao.selectChannels();
	}

	@Override
	public List<Category> selectCategorys(Integer id) {
		// TODO Auto-generated method stub
		return articleDao.selectCategorys(id);
	}

	@Override
	public void addArticle(Article article) {
		articleDao.addArticle(article);
		
	}

	@Override
	public PageInfo<Article> selectHotArticleByAdmin(Article article, Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<Article> list =articleDao.selectHotArticleByAdmin(article);
		return new PageInfo<Article>(list);
	}

	@Override
	public PageInfo<Article> selectByChannelId(Integer pageNum, Integer pageSize, Integer channel_id) {
		PageHelper.startPage(pageNum, 20);
		List<Article> list =articleDao.selectByChannelId(channel_id);
		return new PageInfo<Article>(list);
	}
}
