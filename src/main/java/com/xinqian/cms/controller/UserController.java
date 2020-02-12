package com.xinqian.cms.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bw.utils.StringUtil;
import com.github.pagehelper.PageInfo;
import com.xinqian.cms.domain.User;
import com.xinqian.cms.service.UserService;
import com.xinqian.cms.utils.CMSJsonUtil;
import com.xinqian.cms.utils.PageUtil;
import com.xinqian.cms.vo.UserVo;
@RequestMapping("user")
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("selectUsers")
	public Object selectUsers(Model m,@RequestParam(defaultValue = "")String username,@RequestParam(defaultValue = "1")Integer pageNum,@RequestParam(defaultValue = "3")Integer pageSize) {
		PageInfo<User> page = userService.selectUsers(username, pageNum, pageSize);
		//调用分页的工具类
		
		m.addAttribute("list", page.getList());
		m.addAttribute("username",username);
		m.addAttribute("page",page);
		int[] pageNums = page.getNavigatepageNums();
		m.addAttribute("pageNums",pageNums);
		return "admin/user";
	}
	@ResponseBody
	@RequestMapping("updateLocked")
	public boolean updateLocked(User user) {
		int i = userService.updateLocked(user);
		if (i>0) {
			return true;
		}else {
			return false;
		}
	}
	//跳转到登录界面
	@GetMapping("login")
	public String toLogin() {
		return "index/login";
	}
	
	//登录
	@ResponseBody
	@PostMapping("login")
	public Object login(User user,HttpSession session) {
		CMSJsonUtil cju=new CMSJsonUtil();
		//验证
		boolean username = StringUtil.isNotEmpty(user.getUsername());
		boolean password = StringUtil.isNotEmpty(user.getPassword());
		//如果为空
		if(!username||!password) {
			cju.setMsg("用户名或密码不能为空");
			return cju;
		}
		//去登陆
		User user2=userService.login(user);
		if (user2==null) {
			cju.setMsg("用户名不存在");
			return cju;
		}
		//验证是否被禁用
		if(user2.getLocked()==1) {
			cju.setMsg("该用户已被禁用，请联系管理员");
			return cju;
		}
		//验证密码
		String md5pwd = DigestUtils.md5Hex(user.getPassword());
		if(!md5pwd.equals(user2.getPassword())) {
			cju.setMsg("密码错误");
			return cju;
		}
		//登录成功，把用户存到session作用域
		session.setAttribute("user", user2);
		//登录成功，跳转到主页
		cju.setMsg("true");
		return cju;
	}
	
	//注销
	@GetMapping("loginout")
	public String loginout(HttpSession session) {
		//session.invalidate();//把session的所有值都清空
		session.removeAttribute("user");
		return "redirect:/main";
	}
	
	//注册
	@GetMapping("reg")
	public String toReg(HttpSession session) {
		return "index/reg";
	}
	
	//去注册
	@ResponseBody
	@PostMapping("reg")
	public Object reg(UserVo user) {
		//注册
		//后台验证非空
		CMSJsonUtil cju=new CMSJsonUtil();
		//验证
		boolean username = StringUtil.isNotEmpty(user.getUsername());
		boolean password = StringUtil.isNotEmpty(user.getPassword());
		boolean checkpwd = StringUtil.isNotEmpty(user.getCheckpwd());
		//如果为空
		if(!username||!password||!checkpwd) {
			cju.setMsg("均不能为空");
			System.out.println("用户名或密码不能为空");
			return cju;
		}
		//验证两次密码输入是否一致
		if (!user.getPassword().equals(user.getCheckpwd())) {
			cju.setMsg("两次密码输入不一致");
			System.out.println("两次密码输入不一致");
			return cju;
		}
		
		//用户名唯一 查询此用户名是否在数据库中存在
		int count=userService.getCntByUsername(user.getUsername());
		if (count>0) {
			cju.setMsg("用户名存在，请重新输入");
			System.out.println("用户名存在，请重新输入");
			return cju;
		}
		//注册之前对密码进行md5加密
		String md5pwd = DigestUtils.md5Hex(user.getPassword());
		
		//加密后覆盖新密码
		user.setPassword(md5pwd);
		//注册
		
		userService.insertUser(user);
		cju.setMsg("true");
		return cju;
	}
	
	
}
