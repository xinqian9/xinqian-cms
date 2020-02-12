package com.xinqian.cms.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.xinqian.cms.domain.User;
import com.xinqian.cms.vo.UserVo;

public interface UserService {
	PageInfo<User> selectUsers(String username,Integer pageNum,Integer pageSize);
	
	int updateLocked(User user);
	
	User selectUserById(Integer id);

	User login(User user);

	int getCntByUsername(String username);

	void insertUser(UserVo uVo);

}
