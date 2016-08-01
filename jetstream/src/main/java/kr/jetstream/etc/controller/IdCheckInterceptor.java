package kr.jetstream.etc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class IdCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String ref = request.getRequestURI();
		System.out.println("inter" + ref);

		if(ref != null) {
			ref = ref.replace("/jetstream", "");
		}
		
		if (request.getSession(false).getAttribute("member") == null) {
			response.sendRedirect("/jetstream/login.do?ref=" + ref);
			return false;
		}
		return true;
	}
}