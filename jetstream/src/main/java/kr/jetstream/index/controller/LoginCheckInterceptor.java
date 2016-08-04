package kr.jetstream.index.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("interceptor");
		if(request.getSession(false).getAttribute("member")==null){

			response.sendRedirect("/jetstream/login.do");
			return false;
		}
		
		
		return true;
	}
}
