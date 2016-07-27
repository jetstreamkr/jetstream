package kr.jetstream.card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.jetstream.card.dto.CardDTO;
import kr.jetstream.card.service.CardService;

@Controller
public class CardCreateController {
	@Autowired
	CardService service;
	
	@RequestMapping(value="/board/card_create.do", method=RequestMethod.POST)
	public String creatCard(CardDTO card){
		service.createCard(card);
		return "redirect:/board/board_list.do?board_id=" + card.getBoard_id();
	}
}
