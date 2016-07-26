package kr.jetstream.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.jetstream.board.dto.BoardDTO;
import kr.jetstream.board.service.BoardService;
@Controller
public class BoardInsertController {
	@Autowired
	BoardService service;
	
	@RequestMapping(value="/board/boardCreate.do", method=RequestMethod.POST)
	public String insert(BoardDTO document){
		System.out.println(document.toString());
		
		service.insertDocument(document);
		return "redirect:/dashboard.do";
	}

}
