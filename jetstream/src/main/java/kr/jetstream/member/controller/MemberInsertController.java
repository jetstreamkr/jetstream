package kr.jetstream.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.jetstream.member.dto.MemberDTO;
import kr.jetstream.member.service.MemberService;

@Controller
public class MemberInsertController {
	@Autowired
	MemberService service;

	@RequestMapping(value = "/signin.do", method = RequestMethod.GET)
	public ModelAndView insertForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/insert");
		return mav;
	}
	
	@RequestMapping(value = "/signin.do", method = RequestMethod.POST)
	public String runInsert(String email, String password, String name) {
		MemberDTO member = new MemberDTO(email, password, name);
		service.insert(member);
		return "index";
	}
}