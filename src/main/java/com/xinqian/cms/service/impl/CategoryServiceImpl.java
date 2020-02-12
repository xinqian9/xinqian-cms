package com.xinqian.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xinqian.cms.dao.CategoryDao;
import com.xinqian.cms.domain.Category;
import com.xinqian.cms.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryDao categoryDao;
	@Override
	public List<Category> selectChannels(Integer channel_id) {
		// TODO Auto-generated method stub
		return categoryDao.selectChannels(channel_id);
	}
	@Override
	public List<Category> selectCategorys(Integer id) {
		// TODO Auto-generated method stub
		return categoryDao.selectCategorys(id);
	}
}
