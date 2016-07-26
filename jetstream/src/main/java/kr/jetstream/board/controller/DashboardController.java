package kr.jetstream.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.jetstream.board.dto.BoardDTO;
import kr.jetstream.board.service.BoardService;

@Controller
public class DashboardController {
	@Autowired
	BoardService service;
	
	@RequestMapping("/dashboard.do")
	public ModelAndView getBoardList(){
		List<BoardDTO> boardList = service.findAll();
		return new ModelAndView("dashboard","boardList",boardList);
		
	}
}
