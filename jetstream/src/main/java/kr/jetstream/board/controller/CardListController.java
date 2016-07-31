//package kr.jetstream.board.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import kr.jetstream.board.dto.BoardDTO;
//import kr.jetstream.board.service.BoardService;
//import kr.jetstream.card.dto.CardDTO;
//import kr.jetstream.card.service.CardService;
//import kr.jetstream.pack.dto.PackDTO;
//import kr.jetstream.pack.service.PackService;
//
//@Controller
//public class CardListController {
//	@Autowired
//	BoardService boardService;
//	
//	@Autowired
//	PackService packService;
//	
//	@Autowired
//	CardService cardService;
//	
//	@RequestMapping(value="/board/card_view.do", method=RequestMethod.GET)
//	public ModelAndView boardList(String card_id){
//		ModelAndView mav = new ModelAndView();
//		CardDTO card = cardService.cardView(card_id);
//		
//		mav.addObject("cardVal", card);
//		mav.addObject("code", "OK");
//
//		return mav;
//	}
//	
//}
