package com.xinqian.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;

import com.xinqian.cms.dao.ChannelDao;
import com.xinqian.cms.domain.Channel;
import com.xinqian.cms.service.ChannelService;
@Service
public class ChannelServiceImpl implements ChannelService{
	@Autowired
	private ChannelDao channelDao;

	@Override
	public List<Channel> selectChannels() {
		// TODO Auto-generated method stub
		return channelDao.selectChannels();
	}
}
