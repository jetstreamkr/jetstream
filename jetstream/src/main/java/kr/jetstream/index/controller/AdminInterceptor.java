package kr.jetstream.index.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.jetstream.member.dto.MemberDTO;

public class AdminInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Admininterceptor");
		MemberDTO member = new MemberDTO(); 
		member = (MemberDTO) request.getSession(false).getAttribute("member");
		if(request.getRequestURI().equals(request.getContextPath()+"/admin/index.do")&&member!=null&&member.getMember_st().equals("A")){
				return true;
			
		}

		else {
			System.out.println("ø§Ω∫∞°ø‰√ªµ ");
			response.sendRedirect(request.getContextPath()+"/dashboard.do");
			return false;
		}
	}
}
