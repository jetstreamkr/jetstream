package kr.jetstream.card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.jetstream.card.dto.AssignDTO;
import kr.jetstream.card.service.CardService;

@Controller
public class AssignController {
	@Autowired
	CardService service;
	
	// 담당자 추가
	@RequestMapping(value="/board/assign_add.do", method=RequestMethod.POST)
	public ModelAndView addAssign(String card_id, String member_id){
		ModelAndView mav = new ModelAndView();
				
		AssignDTO assign = new AssignDTO();
		assign.setCard_id(card_id);
		assign.setMember_id(member_id);
		
		service.addAssign(assign);
		
		mav.setViewName("redirect:/board/card_view.do?card_id=" + assign.getCard_id());
		return mav;
	}
	
	// 담당자 삭제
	@RequestMapping(value="/board/assign_close.do", method=RequestMethod.POST)
	public ModelAndView closeAssign(String card_id, String member_id){
		ModelAndView mav = new ModelAndView();
		
		AssignDTO assign = new AssignDTO();
		assign.setCard_id(card_id);
		assign.setMember_id(member_id);
		
		service.closeAssign(assign);
		
		mav.setViewName("redirect:/board/card_view.do?card_id=" + assign.getCard_id());
		return mav;
	}
	
	// 담당자 체크
	@RequestMapping(value="/board/assign_chk.do", method=RequestMethod.POST)
	public ModelAndView chkAssign(String card_id, String member_id){
		ModelAndView mav = new ModelAndView();
		
		AssignDTO assign = new AssignDTO();
		assign.setCard_id(card_id);
		assign.setMember_id(member_id);
		
		service.chkAssign(assign);
		
		int assignChk = service.chkAssignDone(card_id);
		if(assignChk == 0) {
			service.chkAssignSet(card_id);
		}
		
		mav.setViewName("redirect:/board/card_view.do?card_id=" + assign.getCard_id());
		return mav;
	}
}
