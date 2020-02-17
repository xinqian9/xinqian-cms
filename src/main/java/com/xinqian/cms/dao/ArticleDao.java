package com.xinqian.cms.dao;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.xinqian.cms.domain.Article;
import com.xinqian.cms.domain.Category;
import com.xinqian.cms.domain.Channel;

public interface ArticleDao {

	void updateArticle(Article article);

	List<Article> selectArticleByAdmin(Article article);

	Article selectArticleById(Integer id);

	List<Channel> selectChannels();

	List<Category> selectCategorys(Integer id);

	void addArticle(Article article);

	List<Article> selectHotArticleByAdmin(Article article);

	List<Article> selectByChannelId(Integer channel_id);
}
