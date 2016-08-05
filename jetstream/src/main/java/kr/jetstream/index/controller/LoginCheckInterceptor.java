package kr.jetstream.index.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.jetstream.member.dto.MemberDTO;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("interceptor");
		MemberDTO member = new MemberDTO(); 
		member = (MemberDTO) request.getSession(false).getAttribute("member");		
		if(member==null&&request.getRequestURI().equals("/jetstream/board/board_list.do")){
			return true;
		}else if(member==null){
			response.sendRedirect("/jetstream/login.do");
			return false;
		}
		
		
		return true;
	}
}
