package com.xinqian.cms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bw.utils.StringUtil;
import com.github.pagehelper.PageInfo;
import com.xinqian.cms.domain.Article;
import com.xinqian.cms.domain.Category;
import com.xinqian.cms.domain.Channel;
import com.xinqian.cms.domain.Slide;
import com.xinqian.cms.domain.User;
import com.xinqian.cms.service.ArticleService;
import com.xinqian.cms.service.CategoryService;
import com.xinqian.cms.service.ChannelService;
import com.xinqian.cms.service.SlideService;
import com.xinqian.cms.service.UserService;
import com.xinqian.cms.utils.CMSJsonUtil;

@Controller
public class AdminController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private ChannelService channelService;
	@Autowired
	private SlideService slideService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private UserService userService;
	//后台管理系统入口
	@RequestMapping("admin")
	public String admin() {
		return "admin/index";
	}
	//个人中心入口
	@RequestMapping("index")
	public String index(Model m,@RequestParam(defaultValue = "1")Integer pageNum,@RequestParam(defaultValue = "3")Integer pageSize,Article article,HttpSession session) {
		//从session中获得登陆的用户
		User user = (User) session.getAttribute("user");
		System.out.println(user);
		if (null!=user) {
			article.setUser_id(user.getId());
		}
		System.out.println("article:====="+user.getId());
		//查询所有文章
		PageInfo<Article> page = articleService.selectArticleByAdmin(article,pageNum,pageSize);
		m.addAttribute("list", page.getList());
		m.addAttribute("article",new Article());
		m.addAttribute("page", page);
		return "mine/index";
	}
	
	//首页入口
	@RequestMapping("main")
	public String main(Model m,Article article,@RequestParam(defaultValue = "1")Integer pageNum,@RequestParam(defaultValue = "3")Integer pageSize) {
		//查询所有栏目
		List<Channel> channelList = channelService.selectChannels();
		m.addAttribute("channelList", channelList);
		//如果文章中的channel_id有值，则点击了栏目，那么就查询此栏目下的文章
		if(article.getChannel_id()!=null) {
			//先查询此栏目下的分类
			List<Category> categories = categoryService.selectCategorys(article.getChannel_id());
			m.addAttribute("categories", categories);
			//查询此栏目或此分类下的文章
			PageInfo<Article> pInfo3 = articleService.selectArticleByAdmin(article, pageNum,20);
			
			m.addAttribute("page", pInfo3);
			m.addAttribute("cateArticles", pInfo3.getList());
		}else {
			//如果栏目id==null 第一次进入   轮播图和热门文章
			//查询所有广告图片(轮播图)
			List<Slide> slideList = slideService.selectSlides();
			m.addAttribute("slideList", slideList);
			//查询所有热门文章
			article.setHot(1);
			PageInfo<Article> pInfo = articleService.selectArticleByAdmin(article,pageNum,20);
			m.addAttribute("hotArticles", pInfo.getList());
		}
		m.addAttribute("article",article);

		//显示最新文章
		PageInfo<Article> pInfo2 = articleService.selectArticleByAdmin(article, pageNum, pageSize);
		m.addAttribute("newArticles", pInfo2.getList());
		PageInfo<Article> pInfo = articleService.selectHotArticleByAdmin(article,pageNum,10);
		m.addAttribute("hot", pInfo.getList());
		return "index/main";
	}
	//管理员去登录
	@RequestMapping("admin/login")
	public Object toLogin() {
		return "admin/login";
	}
	
	//管理员登录
	@ResponseBody
	@RequestMapping("login")
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
		if (!user2.getRole().equals(1)) {
			cju.setMsg("请输入管理员账号");
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
	
}
