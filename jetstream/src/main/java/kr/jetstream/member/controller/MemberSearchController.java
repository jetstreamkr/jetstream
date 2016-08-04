package kr.jetstream.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.jetstream.member.service.MemberService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class MemberSearchController {
	@Autowired
	MemberService service;

	@RequestMapping(value = "/member/board_search.do", method = RequestMethod.POST)
	public void memberSearch(HttpServletResponse response,String searchData) {

		/*Map<String, String> resultMap = new HashMap();
		//resultMap = service.findMember1(searchData);
		//Map<String, Integer> resultMap = new HashMap();
		resultMap.put("result", "1");
		resultMap.put("result2", "2");
		resultMap.put("result3", "3");
		
		 
		ModelAndView mav = new ModelAndView();
		//System.out.println(resultList.size());
		
		//ModelAndView mav = new ModelAndView("jsonView", resultMap);
		 mav.addObject("resultMap",resultMap);
		 mav.setViewName("jsonView");
		 
		 
		 return mav;*/
		
		List<String> memberList =service.findMember(searchData);
		System.out.println("size"+memberList.size());
		JSONArray list = new JSONArray();
		JSONObject object = new JSONObject();
		
		for(int i=0; i<memberList.size();i++){
	        object.put("label", memberList.get(i));
	        object.put("category","Member");
	        list.add(object);
		}
        
		PrintWriter pw=null;
		try {
			pw = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    pw.print(list);
	    pw.flush();
	    pw.close();
	}
}