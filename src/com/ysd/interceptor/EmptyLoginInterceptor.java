package com.ysd.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;



public class EmptyLoginInterceptor extends HandlerInterceptorAdapter{
	
	/**
	 * RequestMapping 执行之前,执行preHandle
	 * 拦截器
	 * 
	 * 
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		System.out.println("preHandle 被拦截的方法是----------handler => "+handler);
		response.setHeader("Access-Control-Allow-Origin", "*");	
		return true;
	}
	
	/**
	 * RequestMapping 执行之后,执行postHandle,此时并未真正分发视图
	 */
	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
//		System.out.println("postHandle ----------modelAndView => "+modelAndView);
//		modelAndView.setViewName("");//可以控制分发的视图
		response.setHeader("Access-Control-Allow-Origin", "*");	
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		
	}
	
	

	
	/**
	 * RequestMapping 执行之后,执行postHandle,视图也分发完毕.
	 * 1. 相当于 finally
	 * 2.方法执行异常
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,	HttpServletResponse response, Object handler, Exception ex)	throws Exception {
		System.out.println("afterCompletion ----------ex => "+ex);
		response.setHeader("Access-Control-Allow-Origin", "*");	
		
	}

	
	
	
	

}
