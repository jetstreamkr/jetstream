package kr.jetstream.board.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.jetstream.board.dto.BoardDTO;
import kr.jetstream.board.service.BoardService;
import kr.jetstream.member.dto.MemberDTO;

@Controller
public class BoardSetController {
	@Autowired
	BoardService boardService;
	
	// GET���� �Ѿ�� ��� ���� �� ǥ��
	@RequestMapping(value="/board/board_set.do",method=RequestMethod.GET)
	public ModelAndView boardSetForm(HttpSession session, String board_id) {
		
		ModelAndView mav = new ModelAndView();
		
		BoardDTO board = new BoardDTO();
		List<MemberDTO> boardMemberList = null;
		String member_id;
		String set_ok = "N";
		
		// �α����� �ȵǾ� ������ �׳� ���� ����
		if (session.getAttribute("member") == null) {
			board = boardService.viewBoard(board_id);
			
		// �α����� �Ǿ������� ���ǿ��� ���̵� ����
		} else {
			MemberDTO member = (MemberDTO)session.getAttribute("member");
			member_id = member.getMember_id();

			BoardDTO dto = new BoardDTO();
			dto.setBoard_id(board_id);
			dto.setMember_id(member_id);
			board = boardService.viewMyBoard(dto);
			
			if(board == null) {
				board = boardService.viewBoard(board_id);
			} else {
				set_ok = "Y";
				boardMemberList = boardService.viewBoardMember(board_id);
				
			}
		}
		
		mav.addObject("board", board);
		mav.addObject("boardMemberList", boardMemberList);
		mav.addObject("set_ok", set_ok);
		mav.setViewName("board/set");
		return mav;
	}
	
	// POST�� �Ѿ�� ��� ����
	@RequestMapping(value="/board/board_set.do",method=RequestMethod.POST)
	public ModelAndView boardSet(BoardDTO board){
		ModelAndView mav = new ModelAndView();
//		BoardDTO board = boardService.setBoard(board_id);
		
		mav.addObject("board", board);
		mav.setViewName("board/set");
		return mav;
	}

	
}
