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
<<<<<<< HEAD
	public ModelAndView cardSet(String card_id, String card_start, String card_due, String card_txt, String card_nm, String card_order, String option){
		ModelAndView mav = new ModelAndView();

		CardDTO card = new CardDTO();
		card.setCard_id(card_id);
		
		if(option.equals("start")) {
			card.setCard_start(card_start);
			cardService.setCardStart(card);
			
		} else if(option.equals("due")) {
			card.setCard_due(card_due);
			cardService.setCardDue(card);
			
		} else if(option.equals("txt")) {
			card.setCard_txt(card_txt);
			cardService.setCardTxt(card);
		
		} else if(option.equals("nm")) {
			card.setCard_nm(card_nm);
			cardService.setCardNm(card);
		
		} else if(option.equals("order")) {
			card.setCard_order(card_order);
			cardService.setCardOrder(card);
		}
		
		
		mav.setViewName("redirect:/board/card_view.do?card_id=" + card.getCard_id());
=======
	public ModelAndView cardSet(CardDTO card){
		ModelAndView mav = new ModelAndView();

		cardService.setCard(card);
		
		mav.addObject("card", card);
		mav.setViewName("card/card_view");
>>>>>>> refs/remotes/origin/jisung
		return mav;
	}
	
}
