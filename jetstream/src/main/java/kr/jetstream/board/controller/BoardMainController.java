package kr.jetstream.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.jetstream.board.dto.BoardDTO;
import kr.jetstream.board.service.BoardService;
import kr.jetstream.card.dto.CardDTO;
import kr.jetstream.card.service.CardService;
import kr.jetstream.member.dto.MemberDTO;

@Controller
public class BoardMainController {
	@Autowired
	BoardService boardService;
	
	@Autowired
	CardService cardService;
	
	@RequestMapping(value="/board/board_main.do", method=RequestMethod.GET)
	public ModelAndView getBoardView(HttpSession session, String board_id) {
		ModelAndView mav = new ModelAndView();

		BoardDTO board = new BoardDTO();
		String member_id;
		String set_ok = "N";
		
		// 로그인이 안되어 있으면 그냥 보드 보기
		if (session.getAttribute("member") == null) {
			board = boardService.viewBoard(board_id);
			System.out.println("아무것도");
			
		// 로그인이 되어있으면 세션에서 아이디 받음
		} else {
			MemberDTO member = (MemberDTO)session.getAttribute("member");
			member_id = member.getMember_id();

			BoardDTO dto = new BoardDTO();
			dto.setBoard_id(board_id);
			dto.setMember_id(member_id);
			board = boardService.viewMyBoard(dto);
			System.out.println("여기임");
			
			if(board == null) {
				board = boardService.viewBoard(board_id);
				System.out.println("여기까지옴");
			} else {
				set_ok = "Y";
			}
		}
		
		List<CardDTO> cardList = cardService.cardList(board_id, "main");

		mav.addObject("board", board);
		mav.addObject("set_ok", set_ok);
		mav.addObject("cardList", cardList);
		mav.setViewName("board/main");
		return mav;
		
	}

}