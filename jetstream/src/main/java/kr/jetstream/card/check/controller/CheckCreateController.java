package kr.jetstream.card.check.controller;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.jetstream.card.check.dto.CheckListDTO;
import kr.jetstream.card.check.service.CheckListService;

@Controller
public class CheckCreateController {
	
	@Autowired
	CheckListService service;
	
	@RequestMapping(value="/board/checkcreate.do", method=RequestMethod.POST)
	public void createChecklist(HttpServletRequest req, HttpServletResponse res, 
			String board_id,String list_id, String card_id, String chklist_txt) throws Exception{
		
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
		CheckListDTO dto =  new CheckListDTO(board_id,list_id,card_id,chklist_txt);
		service.create(dto);
		List<CheckListDTO> list = service.showlist(board_id);
		PrintWriter pw = res.getWriter();
		for(int i=0;i<list.size();i++){
			CheckListDTO chk = list.get(i);
			String cid = chk.getCard_id();
			String chk_txt = chk.getChklist_txt();
			if(card_id.equals(cid)){
				pw.print("<div>"+ chk_txt+"  <input type='checkbox' name='chkbox' id='chkbox' class='chkbox-"+card_id+"'/></div>");
			}
		}
		
		
	}
}
