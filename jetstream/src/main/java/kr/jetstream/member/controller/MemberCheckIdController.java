package kr.jetstream.member.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.jetstream.member.service.MemberService;

@Controller
public class MemberCheckIdController {
	
	@Autowired
	MemberService service;
	
	@RequestMapping(value = "/check_id.do", method=RequestMethod.POST)
	public void checkId(HttpServletRequest req, HttpServletResponse res) throws Exception{
		String email = req.getParameter("email");
		boolean state = service.CheckId(email);
		System.out.println("testings");
		String result = "";
		if(state){
			result = "사용가능한 아이디입니다.";
		}else{
			result = "<font color=red>이미 존재하는 아이디입니다.</font>";
		}
		JSONObject json = new JSONObject();
		json.put("state", state);
		json.put("result", result);
		
		
		res.setContentType("application/json;charset=utf-8");
		
				
		PrintWriter pw = res.getWriter();
		pw.print(json.toJSONString());
	}
}
