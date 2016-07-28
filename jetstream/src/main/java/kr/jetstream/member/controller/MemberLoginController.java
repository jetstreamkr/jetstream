package kr.jetstream.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.jetstream.member.dto.MemberDTO;
import kr.jetstream.member.service.MemberService;

@Controller
public class MemberLoginController {

	@Autowired
	MemberService service;
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String showpage() {
		return "member/login";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(HttpSession session, String email, String password) {
		MemberDTO member = service.login(email, password);
		if (member != null) {
			session.setAttribute("member", member);
			session.setAttribute("initial", member.getMember_nm().substring(0, 1));
			return "dashboard";
		}else{
			return "error/login";
		}
	}
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.removeAttribute("member");
		return "index";
	}
	
}