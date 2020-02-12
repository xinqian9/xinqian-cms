package com.xinqian.cms.dao;

import java.util.List;

import com.xinqian.cms.domain.Category;

public interface CategoryDao {
	//查询本栏目下的分类
	public List<Category> selectChannels(Integer channel_id);

	public List<Category> selectCategorys(Integer id);
}
