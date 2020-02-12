package com.xinqian.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xinqian.cms.dao.SlideDao;
import com.xinqian.cms.domain.Slide;
import com.xinqian.cms.service.SlideService;
@Service
public class SlideServiceImpl implements SlideService{
	@Autowired
	private SlideDao slideDao;
	@Override
	public List<Slide> selectSlides() {
		// TODO Auto-generated method stub
		return slideDao.selectSlides();
	}

}
