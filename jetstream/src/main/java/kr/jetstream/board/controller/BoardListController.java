package kr.jetstream.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.jetstream.board.dto.BoardDTO;
import kr.jetstream.board.service.BoardService;
import kr.jetstream.card.attach.dto.FileDTO;
import kr.jetstream.card.attach.service.AttachService;
import kr.jetstream.card.dto.CardDTO;
import kr.jetstream.card.service.CardService;
import kr.jetstream.pack.dto.PackDTO;
import kr.jetstream.pack.service.PackService;

@Controller
public class BoardListController {
	@Autowired
	BoardService boardService;
	
	@Autowired
	PackService packService;
	
	@Autowired
	CardService cardService;
	
	@Autowired
	AttachService attachservice;
	
	@RequestMapping(value="/board/board_list.do", method=RequestMethod.GET)
	public ModelAndView boardList(String board_id){
		ModelAndView mav = new ModelAndView();
		BoardDTO board = boardService.viewBoard(board_id);
		List<PackDTO> packList = packService.packList(board_id);
		List<CardDTO> cardList = cardService.cardList(board_id);
		List<FileDTO> filelist = attachservice.list(board_id);
		
		mav.addObject("board", board);
		mav.addObject("packList", packList);
		mav.addObject("cardList", cardList);
		mav.addObject("fileList", filelist);
		mav.setViewName("board/list");
		return mav;
	}
	
}
