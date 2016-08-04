package kr.jetstream.checklist.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.jetstream.checklist.dto.CheckListDTO;
import kr.jetstream.checklist.service.CheckListService;

@Controller
public class CheckStateController {
	@Autowired
	CheckListService service;
	
	@RequestMapping(value="/board/checkstate.do", method=RequestMethod.POST)
	public void state(HttpServletRequest req, HttpServletResponse res, String card_id, String chklist_id, String state) throws Exception{
		
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
		System.out.println("test");
		CheckListDTO dto = new CheckListDTO(card_id, chklist_id);		
		service.changeState(dto,state);
		
	}
}
