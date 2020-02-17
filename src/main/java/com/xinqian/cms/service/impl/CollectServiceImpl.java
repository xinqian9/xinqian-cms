package com.xinqian.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bw.utils.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xinqian.cms.dao.CollectDao;
import com.xinqian.cms.domain.Collect;
import com.xinqian.cms.exception.CMSRuntimeException;
import com.xinqian.cms.service.CollectService;

@Service
public class CollectServiceImpl implements CollectService{
	@Autowired
	private CollectDao collectDao;

	@Override
	public void isHttpUrl(Collect collect) {
		String url = collect.getUrl();
		if (StringUtil.isHttpUrl(url)) {
			collect.setUrl(url);
		}else {
			System.out.println("输入的网址不合法");
		}
		
	}

	@Override
	public void desc(Collect collect) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PageInfo<Collect> selectCollects(Collect collect, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, 5);
		List<Collect> list=collectDao.selectCollects(collect);
		return new PageInfo<Collect>(list);
	}

	@Override
	public boolean deleteCollect(Collect collect) {
		// TODO Auto-generated method stub
		return collectDao.deleteCollect(collect)>0;
	}

	@Override
	public int addCollect(Collect collect) throws CMSRuntimeException {
		int result=0;
		if (!StringUtil.isHttpUrl(collect.getUrl())) {
			throw new CMSRuntimeException("url不合法");
		}else {
			result=collectDao.addCollect(collect);
		}
		return result;
	}
}
