package kr.jetstream.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.jetstream.board.service.BoardService;

@Controller
public class BoardCloseController {
	@Autowired
	BoardService service;
	
	@RequestMapping(value="/board/board_close.do", method=RequestMethod.POST)
	public String closeBoard(String board_id){
		service.closeBoard(board_id);
		return "redirect:/dashboard.do";
	}
}
