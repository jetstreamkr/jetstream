package kr.jetstream.card.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.jetstream.board.service.BoardService;
import kr.jetstream.card.dto.AssignDTO;
import kr.jetstream.card.dto.CardDTO;
import kr.jetstream.card.service.CardService;
import kr.jetstream.comment.dto.CommentDTO;
import kr.jetstream.comment.service.CommentService;
import kr.jetstream.member.dto.MemberDTO;

@Controller
public class CardViewController {
	@Autowired
	CardService cardService;
	
	@Autowired
	BoardService boardService;
	
	
	@Autowired
	CommentService commentService;
	
	@RequestMapping(value="/board/card_view.do", method=RequestMethod.GET)
	public ModelAndView viewCard(String card_id){
		ModelAndView mav = new ModelAndView();

		// ī��
		CardDTO card = cardService.viewCard(card_id);
		
		// ���
		List<CommentDTO> commentList = commentService.viewComment(card_id);
		
		// üũ����Ʈ
		
		// ��
		
		// �����
		List<AssignDTO> assignList = cardService.viewAssign(card_id);
		System.out.println(card_id + assignList.toString());
		
		// ������
		// ���� ��� ����
		List<MemberDTO> boardMemberList = boardService.viewBoardMember(card.getBoard_id());
		
		mav.addObject("card", card);
		mav.addObject("commentList", commentList);
		mav.addObject("assignList", assignList);
		mav.addObject("boardMemberList", boardMemberList);
		mav.setViewName("card/card_view");
		return mav;
	}
	
}
