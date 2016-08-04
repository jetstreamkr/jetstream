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
	
	@RequestMapping(value="/board/board_list.do", method=RequestMethod.GET)
	public ModelAndView boardList(HttpSession session, String board_id,
			@RequestParam(value="card_id", defaultValue="none") String card_id) {
		ModelAndView mav = new ModelAndView();

		BoardDTO board = new BoardDTO();
		String member_id;
		String set_ok = "N";
		
		// 로그인이 안되어 있으면 그냥 보드 보기
		if (session.getAttribute("member") == null) {
			board = boardService.viewBoard(board_id);
			
		// 로그인이 되어있으면 세션에서 아이디 받음
		} else {
			MemberDTO member = (MemberDTO)session.getAttribute("member");
			member_id = member.getMember_id();

			BoardDTO dto = new BoardDTO();
			dto.setBoard_id(board_id);
			dto.setMember_id(member_id);
			board = boardService.viewMyBoard(dto);
			
			// 로그인한 상태지만 내 보드가 아닐 경우 그냥 보드 보기
			if(board == null) {
				board = boardService.viewBoard(board_id);
			} else {
				set_ok = "Y";
			}
		}

		List<PackDTO> packList = packService.packList(board_id);
		List<CardDTO> cardList = cardService.cardList(board_id, "list");
		
		// 카드 아이디를 받아왔을 경우 카드 정보를 넘겨서 모달 자동으로 띄우기
		if (!card_id.equals("none")) {
			mav.addObject("card_id", card_id);
		}
		
		
		mav.addObject("board", board);
		mav.addObject("set_ok", set_ok);
		mav.addObject("packList", packList);
		mav.addObject("cardList", cardList);
		mav.setViewName("board/list");
		return mav;
	}
	
}
