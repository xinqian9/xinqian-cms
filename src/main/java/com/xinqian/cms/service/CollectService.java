package com.xinqian.cms.service;

import com.github.pagehelper.PageInfo;
import com.xinqian.cms.domain.Collect;
import com.xinqian.cms.exception.CMSRuntimeException;

public interface CollectService {
	public void isHttpUrl(Collect collect);
	
	public void desc(Collect collect);

	public PageInfo<Collect> selectCollects(Collect collect, Integer pageNum, Integer pageSize);

	public boolean deleteCollect(Collect collect);

	public int addCollect (Collect collect) throws CMSRuntimeException;
}
