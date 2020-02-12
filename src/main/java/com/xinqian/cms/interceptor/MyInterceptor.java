package com.xinqian.cms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.xinqian.cms.domain.User;

public class MyInterceptor implements HandlerInterceptor{
	//请求处理之前被调用(控制器方法调用之前)
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		User user = (User) request.getSession().getAttribute("user");
		if (user!=null) {
			//放行
			return true;
		}else {
			//证明登录失败或者没有登录
			request.setAttribute("error","请先登录");
			String requestURI = request.getRequestURI();
			if (requestURI.equals("/index")) {
				request.getRequestDispatcher("WEB-INF/view/index/login.jsp").forward(request, response);
			}
			if (requestURI.equals("/admin")) {
				request.getRequestDispatcher("WEB-INF/view/admin/login.jsp").forward(request, response);
			}
			return false;
		}
		
	}
	//控制器方法调用之后
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}
	//视图渲染之后
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
