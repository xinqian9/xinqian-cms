package com.xinqian.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xinqian.cms.dao.UserDao;
import com.xinqian.cms.domain.User;
import com.xinqian.cms.service.UserService;
import com.xinqian.cms.vo.UserVo;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	@Override
	public PageInfo<User> selectUsers(String username, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<User> list = userDao.selectUsers(username);
		return new PageInfo<User>(list);
	}

	@Override
	public int updateLocked(User user) {
		
		return userDao.updateLocked(user);
	}

	@Override
	public User selectUserById(Integer id) {
		// TODO Auto-generated method stub
		return userDao.selectUserById(id);
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}

	@Override
	public int getCntByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.getCntByUsername(username);
	}

	@Override
	public void insertUser(UserVo uVo) {
		// TODO Auto-generated method stub
		userDao.insertUser(uVo);
	}
}
