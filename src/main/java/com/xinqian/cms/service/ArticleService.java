package com.xinqian.cms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.xinqian.cms.domain.Article;
import com.xinqian.cms.domain.Category;
import com.xinqian.cms.domain.Channel;

public interface ArticleService {

	boolean updateArticle(Article article);

	PageInfo<Article> selectArticleByAdmin(Article article, Integer pageNum, Integer pageSize);

	Article selectArticleById(Integer id);

	List<Channel> selectChannels();

	List<Category> selectCategorys(Integer id);

	void addArticle(Article article);
}
