package com.xinqian.cms.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.xinqian.cms.domain.Article;
import com.xinqian.cms.domain.Category;
import com.xinqian.cms.domain.Channel;
import com.xinqian.cms.domain.Comment;
import com.xinqian.cms.domain.User;
import com.xinqian.cms.service.ArticleService;
import com.xinqian.cms.service.CategoryService;
import com.xinqian.cms.service.ChannelService;
import com.xinqian.cms.service.CommentService;
@RequestMapping("article")
@Controller
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private ChannelService channelService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private CommentService commentService;
	@RequestMapping("selectsByAdmin")
	public String selectsByAdmin(Model m,@RequestParam(defaultValue = "1")Integer pageNum,@RequestParam(defaultValue = "3")Integer pageSize,Article article) {
		PageInfo<Article> page = articleService.selectArticleByAdmin(article,pageNum,pageSize);
		m.addAttribute("list", page.getList());
		m.addAttribute("article",article);
		m.addAttribute("page", page);
		return "admin/article";
	}
	
	@ResponseBody
	@RequestMapping("updateArticle")
	public boolean updateStatus(Article article) {
		return articleService.updateArticle(article);
	}
	
	//@ResponseBody
	@RequestMapping("selectArticleById")
	public Object selectArticleById(Model m,Integer id,Article article,@RequestParam(defaultValue = "1")Integer pageNum,@RequestParam(defaultValue = "10")Integer pageSize) {
		Article article1=articleService.selectArticleById(article.getId());
		m.addAttribute("article", article1);
		//通过文章id查询所有的评论
		PageInfo<Comment> info=commentService.selectComments(article.getId(),pageNum,pageSize);
		m.addAttribute("list",info.getList());
		m.addAttribute("page",info);
		return "mine/content";
	}
	
	@ResponseBody
	@PostMapping("selectArticleById")
	public Object selectArticleBy(Model m,Integer id) {
		Article article=articleService.selectArticleById(id);
		m.addAttribute("article", article);
		return article;
	}
	
	@RequestMapping("toAdd")
	public Object toAdd() {
		return "mine/publish";
	}
	
	@ResponseBody
	@RequestMapping("selectChannels")
	public Object selectChannels() {
		List<Channel> list=channelService.selectChannels();
		System.out.println(list.size());
		return list;
	}
	
	@ResponseBody
	@RequestMapping("selectCategorys")
	public Object selectChannels(@RequestParam("id")Integer id) {
		List<Category> list=categoryService.selectCategorys(id);
		return list;
	}
	
	@ResponseBody
	@RequestMapping("addArticle")
	public boolean addArticle(Article article,@RequestParam("myfile")MultipartFile myfile,HttpSession session) {
		//从session中获得用户信息
		User user = (User) session.getAttribute("user");
		if (null!=user) {
			article.setUser_id(user.getId());
		}
		try {
			if (myfile.getSize()>0) {
				//上传图片
				String path="e:/pic/";
				//获得上传文件的名称
				String realName = myfile.getOriginalFilename();
				//获得后缀
				String suffix = realName.substring(realName.lastIndexOf("."));
				//获得新的文件名称
				String fileName = UUID.randomUUID().toString()+suffix;
				//创建上传文件
				File file = new File(path+fileName);
				myfile.transferTo(file);
				article.setPicture(fileName);
			}
			//添加
			articleService.addArticle(article);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	//个人查看文章
	@RequestMapping("selectArticles")
	public String selectArticles(Model m,@RequestParam(defaultValue = "1")Integer pageNum,@RequestParam(defaultValue = "3")Integer pageSize,Article article,HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (null!=user) {
			article.setUser_id(user.getId());
		}
		PageInfo<Article> page = articleService.selectArticleByAdmin(article,pageNum,pageSize);
		m.addAttribute("list", page.getList());
		m.addAttribute("article",article);
		m.addAttribute("page", page);
		

		return "mine/article";
	}
	@RequestMapping("selectByChannelId")
	public Object selectByChannelId(Model m,@RequestParam(defaultValue = "1")Integer pageNum,Integer pageSize,Integer channel_id) {
		System.out.println(channel_id);
		PageInfo<Article> carticle=articleService.selectByChannelId(pageNum,pageSize,channel_id);
		m.addAttribute("cateArticles", carticle.getList());
		for (Article article : carticle.getList()) {
			System.out.println(article);
		}
		m.addAttribute("page", carticle);
		
		return "index/main";
	}

	

}
