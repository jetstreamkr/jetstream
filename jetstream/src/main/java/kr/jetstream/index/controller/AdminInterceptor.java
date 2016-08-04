package kr.jetstream.index.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AdminInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean masterFlag = false;
		System.out.println("Admininterceptor");
		if(request.getSession(false).getAttribute("member")!=null &&
				 	request.getSession().getAttribute("member_st")=="A"){

			response.sendRedirect("/jetstream/login.do");
			masterFlag = true;
		} else {
			
			response.sendRedirect(request.getContextPath()+"/dashboard.do");
			masterFlag = false;
		}
		
		
		return masterFlag;
	}
}
