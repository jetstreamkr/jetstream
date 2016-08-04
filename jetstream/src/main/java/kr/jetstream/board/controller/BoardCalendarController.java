package kr.jetstream.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.jetstream.board.service.BoardService;
import kr.jetstream.card.dto.CardDTO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class BoardCalendarController {

	@Autowired
	BoardService service;
	
	@RequestMapping(value="/board/board_cal.do", method=RequestMethod.GET)
	public ModelAndView showPage(String board_id){
		System.out.println("캘린더컨트롤"+board_id);
		List<CardDTO> cardList = service.selectCard(board_id);

		JSONArray datalist = new JSONArray();
		JSONObject object;
		
		for(int i=0;i<cardList.size();i++){
			object = new JSONObject();
			object.put("title",cardList.get(i).getCard_nm());
			object.put("start",cardList.get(i).getCard_start().substring(0,10));
			object.put("end",cardList.get(i).getCard_due().substring(0,10));
			datalist.add(object);
		}
		JSONObject object_today;
		object_today = new JSONObject();
		object_today.put("defaultDate", service.selectToday());

		ModelAndView mav = new ModelAndView();

		mav.setViewName("calendar");
		/*mav.addObject("object_today", service.selectToday());*/
			
		mav.addObject("object_today", object_today);
		mav.addObject("datalist", datalist);

		return mav;
	}
}
