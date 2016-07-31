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
	public ModelAndView boardList(HttpSession session, String board_id) {
		ModelAndView mav = new ModelAndView();

		BoardDTO board = new BoardDTO();
		String member_id;
		String set_ok = "N";
		
		// �α����� �ȵǾ� ������ �׳� ���� ����
		if (session.getAttribute("member") == null) {
			board = boardService.viewBoard(board_id);
			System.out.println("�ƹ��͵�");
			
		// �α����� �Ǿ������� ���ǿ��� ���̵� ����
		} else {
			MemberDTO member = (MemberDTO)session.getAttribute("member");
			member_id = member.getMember_id();

			BoardDTO dto = new BoardDTO();
			dto.setBoard_id(board_id);
			dto.setMember_id(member_id);
			board = boardService.viewMyBoard(dto);
			System.out.println("������");
			
			if(board == null) {
				board = boardService.viewBoard(board_id);
				System.out.println("���������");
			} else {
				set_ok = "Y";
			}
		}

		
		List<PackDTO> packList = packService.packList(board_id);
		List<CardDTO> cardList = cardService.cardList(board_id, "list");
		
		mav.addObject("board", board);
		mav.addObject("set_ok", set_ok);
		mav.addObject("packList", packList);
		mav.addObject("cardList", cardList);
		mav.setViewName("board/list");
		return mav;
	}
	
}
