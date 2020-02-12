package com.xinqian.cms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TimeInterceptor implements HandlerInterceptor{
	private long start;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//访问处理器之前先获取系统当前时间
		start = System.currentTimeMillis();
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//获得访问控制器方法后的系统时间
		long end = System.currentTimeMillis();
		long time=end-start;
		String requestURI = request.getRequestURI();
		System.out.println(requestURI+"消耗的时间为："+time+"ms");
		
	}

}
