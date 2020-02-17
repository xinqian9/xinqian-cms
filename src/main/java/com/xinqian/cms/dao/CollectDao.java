package com.xinqian.cms.dao;

import java.util.List;

import com.xinqian.cms.domain.Collect;

public interface CollectDao {

	List<Collect> selectCollects(Collect collect);

	int deleteCollect(Collect collect);

	int addCollect(Collect collect);

}
