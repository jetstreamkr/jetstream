package kr.jetstream.card.check.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.jetstream.card.check.dto.CheckListDTO;
import kr.jetstream.card.check.service.CheckListService;

@Controller
public class CheckStateController {
	@Autowired
	CheckListService service;
	
	@RequestMapping(value="/board/checkstate.do", method=RequestMethod.POST)
	public void state(HttpServletRequest req, HttpServletResponse res, String card_id, String chklist_id) throws Exception{
		
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
		CheckListDTO dto = new CheckListDTO(card_id, chklist_id);
		service.changeState(dto);
	}
}
