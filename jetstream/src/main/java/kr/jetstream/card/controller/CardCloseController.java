package kr.jetstream.card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.jetstream.card.dto.CardDTO;
import kr.jetstream.card.service.CardService;

@Controller
public class CardCloseController {
	@Autowired
	CardService cardService;
	
	@RequestMapping(value="/board/card_close.do", method=RequestMethod.POST)
	public ModelAndView cardClose(String card_id, String board_id){
		ModelAndView mav = new ModelAndView();

		cardService.closeCard(card_id);
		
		mav.setViewName("redirect:/board/board_list.do?board_id=" + board_id);
		return mav;
	}
	
}
