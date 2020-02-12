package com.xinqian.cms.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageInfo;
import com.xinqian.cms.domain.User;
import com.xinqian.cms.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class UserServiceImplTest {
	@Autowired
	private UserService service;
	@Test
	public void testSelectUsers() {
		PageInfo<User> selectUsers = service.selectUsers(null, 1, 3);
		List<User> list = selectUsers.getList();
		for (User user : list) {
			System.out.println(user);
		}
	}
	
	@Test
	public void testUpdateLocked() {
		User user = new User();
		user.setId(124);
		user.setLocked(1);
		service.updateLocked(user);
	}
	
	@Test
	public void testSelectUserById() {
		
		User selectUserById = service.selectUserById(124);
		System.out.println(selectUserById);
	}

}
