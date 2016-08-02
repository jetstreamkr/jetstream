package kr.jetstream.card.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.jetstream.card.dto.CardDTO;
import kr.jetstream.card.service.CardService;
import kr.jetstream.comment.dto.CommentDTO;
import kr.jetstream.comment.service.CommentService;

@Controller
public class CardViewController {
	@Autowired
	CardService cardService;
	
	@Autowired
	CommentService commentService;
	
	@RequestMapping(value="/board/card_view.do", method=RequestMethod.GET)
	public ModelAndView viewCard(String card_id){
		ModelAndView mav = new ModelAndView();

		// 카드
		CardDTO card = cardService.viewCard(card_id);
		
		// 댓글
		List<CommentDTO> commentList = commentService.viewComment(card_id);
		
		// 체크리스트
		
		// 라벨
		
		// 담당자
		
		mav.addObject("card", card);
		mav.addObject("commentList", commentList);
		mav.setViewName("card/card_view");
		return mav;
	}
	
}
