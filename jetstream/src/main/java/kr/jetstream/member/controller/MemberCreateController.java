package kr.jetstream.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.jetstream.mail.controller.AmazonSES;
import kr.jetstream.member.dto.MemberDTO;
import kr.jetstream.member.service.MemberService;

@Controller
public class MemberCreateController {
	@Autowired
	MemberService service;
	
	@Autowired
	AmazonSES sendEmail;

	@RequestMapping(value = "/signin.do", method = RequestMethod.GET)
	public ModelAndView insertForm(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		if(member!=null){
			mav.setViewName("redirect:/dashboard.do");
		}else{
			mav.setViewName("member/insert");
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/signin.do", method = RequestMethod.POST)
	public String runInsert(String email, String password, String member_nm) {
		MemberDTO member = new MemberDTO(email, password, member_nm);
		service.insert(member);
		
		try {
			sendEmail.sendmail(email, member_nm,"welcome");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/index.do";
	}
}