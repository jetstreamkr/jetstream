package kr.jetstream.board.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.jetstream.board.dto.BoardDTO;
import kr.jetstream.board.service.BoardService;

@Controller
public class BoardUpdateController {
	@Autowired
	BoardService service;
	
	@RequestMapping(value="/board/insert",method=RequestMethod.POST)
	public String insert(BoardDTO document){
		service.insertDocument(document);
		return "redirect:/board/list";
		
	}
	
	@RequestMapping(value="/board/update", method=RequestMethod.POST)
	public String update(BoardDTO document){
		service.update(document);
		return "redirect:/board/list";
		
	}
}
