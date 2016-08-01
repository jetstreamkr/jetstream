package kr.jetstream.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.jetstream.board.dto.BoardDTO;
import kr.jetstream.board.service.BoardService;

@Controller
public class BoardMainController {
	@Autowired
	BoardService service;
	
	@RequestMapping(value="/board/board_main.do", method=RequestMethod.GET)
	public ModelAndView getBoardView(String board_id){
		BoardDTO board = service.viewBoard(board_id);
		return new ModelAndView("board/main", "board", board);
		
	}

}






