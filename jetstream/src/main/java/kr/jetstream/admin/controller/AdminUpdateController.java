package kr.jetstream.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.jetstream.admin.service.AdminService;
import kr.jetstream.member.dto.MemberDTO;

@Controller
public class AdminUpdateController {
	@Autowired
	AdminService service;
	
	@RequestMapping(value="/admin/update.do")
	public ModelAndView showUpdateMember(String member_id){
		System.out.println(member_id);
		return new ModelAndView("admin/update", "memberInfo", service.detaileMember(member_id));
	}
	
	@RequestMapping(value="/admin/memberupdate.do")
	public ModelAndView updateMember(MemberDTO memberInfo){
		service.updateMember(memberInfo);
		return new ModelAndView("redirect:index.do");
	}
	
}
