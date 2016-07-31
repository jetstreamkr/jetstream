package kr.jetstream.card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.jetstream.card.dto.CardDTO;
import kr.jetstream.card.service.CardService;

@Controller
public class CardViewController {
	@Autowired
	CardService cardService;
	
	@RequestMapping(value="/board/card_view.do", method=RequestMethod.GET)
	public ModelAndView boardList(String card_id){
		ModelAndView mav = new ModelAndView();
		System.out.println(card_id);
		CardDTO card = cardService.cardView(card_id);
		
		System.out.println(card);
		mav.addObject("card", card);
		mav.setViewName("card/card_view");
		return mav;
	}
	
}
