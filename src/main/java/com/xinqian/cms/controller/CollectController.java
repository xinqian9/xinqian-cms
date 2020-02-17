package com.xinqian.cms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.xinqian.cms.domain.Collect;
import com.xinqian.cms.domain.User;
import com.xinqian.cms.exception.CMSRuntimeException;
import com.xinqian.cms.service.CollectService;

@Controller
@RequestMapping("collect")
public class CollectController {
	@Autowired
	private CollectService collectService;
	
	@RequestMapping("selectCollects")
	public String toCollect(Model m,Integer pageNum,Integer pageSize,Collect collect,HttpSession session) {
		User user = (User) session.getAttribute("user");
		collect.setUser_id(user.getId());
		if (pageNum==null) {
			pageNum=1;
		}
		PageInfo<Collect> pInfo=collectService.selectCollects(collect,pageNum,pageSize);
		m.addAttribute("list", pInfo.getList());
		m.addAttribute("page", pInfo);
		return "mine/collect";
	}
	//收藏
	@ResponseBody
	@RequestMapping("addCollect")
	public int addCollect(Collect collect,HttpSession session) {
		User user=(User) session.getAttribute("user");
		if (user!=null) {
			collect.setUser_id(user.getId());
		}
		int result=0;
		try {
			result=collectService.addCollect(collect);
		} catch (CMSRuntimeException e) {
			result=-1;
			// TODO Auto-generated catch block
			e.getMessage();  //打印异常信息
			e.printStackTrace();
		}
		return result;
	}
	@ResponseBody
	@RequestMapping("deleteCollect")
	public Object deleteCollect(Model m,Collect collect,HttpSession session) {
		User user = (User) session.getAttribute("user");
		collect.setUser_id(user.getId());
		boolean result=collectService.deleteCollect(collect);
		return result;
	}
}
