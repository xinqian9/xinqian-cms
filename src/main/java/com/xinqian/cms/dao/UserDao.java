package com.xinqian.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xinqian.cms.domain.User;
import com.xinqian.cms.vo.UserVo;

public interface UserDao {
	
	List<User> selectUsers(@Param("username")String username);
	
	int updateLocked(User user);
	
	User selectUserById(@Param("id")Integer id);

	User login(User user);

	int getCntByUsername(@Param("username")String username);

	void insertUser(UserVo uVo);
}
