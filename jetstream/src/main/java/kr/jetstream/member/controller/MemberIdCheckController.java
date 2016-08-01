package kr.jetstream.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.jetstream.member.service.MemberService;

@Controller
public class MemberIdCheckController {
	
	@Autowired
	MemberService service;
	
	@RequestMapping(value = "/idcheck.do", method=RequestMethod.POST)
	public void checkId(HttpServletRequest req, HttpServletResponse res, String id) throws Exception{
		
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
		
		try {
			System.out.println(id);
			int check = service.idcheck(id);
			System.out.println(check);
			PrintWriter pw = res.getWriter();
			
			if(check == 1){
				pw.print("이미 존재하는 아이디입니다.");
			}else{
				pw.print("사용가능한 아이디입니다.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
