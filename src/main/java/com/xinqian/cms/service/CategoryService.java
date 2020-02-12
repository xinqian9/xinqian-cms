package com.xinqian.cms.service;

import java.util.List;

import com.xinqian.cms.domain.Category;

public interface CategoryService {
	public List<Category> selectChannels(Integer channel_id);

	public List<Category> selectCategorys(Integer id);
}
