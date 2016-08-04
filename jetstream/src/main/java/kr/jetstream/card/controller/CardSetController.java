package kr.jetstream.card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.jetstream.card.dto.CardDTO;
import kr.jetstream.card.service.CardService;

@Controller
public class CardSetController {
	@Autowired
	CardService cardService;
	
	@RequestMapping(value="/board/card_set.do", method=RequestMethod.POST)
	public ModelAndView cardSet(CardDTO card){
		ModelAndView mav = new ModelAndView();

		cardService.setCard(card);
		
		mav.addObject("card", card);
		mav.setViewName("card/card_view");
		return mav;
	}
	
}
