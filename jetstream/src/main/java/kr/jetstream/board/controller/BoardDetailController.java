package kr.jetstream.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.jetstream.board.dto.BoardDTO;
import kr.jetstream.board.service.BoardService;

@Controller
public class BoardDetailController {
	@Autowired
	BoardService service;
	
	@RequestMapping(value="/board/detail.do")
	public ModelAndView findbyID(String key, String value, String action){
		BoardDTO document = service.findByID(key, value);
		String view = "";
		if(action.equals("read")){
			view = "board_detail";
		}else{
			view = "board_update";
		}
		return new ModelAndView(view, "document", document);
		
	}

}






