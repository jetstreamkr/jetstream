package kr.jetstream.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.jetstream.board.dto.BoardDTO;
import kr.jetstream.board.service.BoardService;
@Controller
public class BoardCreateController {
	@Autowired
	BoardService service;
	
	@RequestMapping(value="/board/board_create.do", method=RequestMethod.POST)
	public String createBoard(BoardDTO board){
		service.createBoard(board);
		String member_id = board.getMember_id();
		String board_id = service.getBoardId(member_id);
		return "redirect:/board/board_set.do?board_id=" + board_id;
	}

}
