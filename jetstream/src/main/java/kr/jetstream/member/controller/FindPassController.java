package kr.jetstream.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.jetstream.mail.controller.AmazonSES;
import kr.jetstream.member.dto.MemberDTO;
import kr.jetstream.member.service.MemberService;

@Controller
public class FindPassController {
	@Autowired
	MemberService serviec;
	
	@Autowired
	AmazonSES sendEmail;
	
	@RequestMapping(value="/find_pass.do")
	public String findPass(){
		return "findPass";
	}
	
	@RequestMapping(value="/sendPassEmail.do")
	public String findPassEmail(String email){
		MemberDTO member = serviec.findPass(email);
		
		try {
			sendEmail.sendmail02(email, member.getPassword(), member.getMember_nm(), "findPass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/login.do";
		
	}
	
	
}
