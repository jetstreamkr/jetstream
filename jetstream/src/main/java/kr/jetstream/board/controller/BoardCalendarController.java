package kr.jetstream.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.jetstream.board.dto.BoardDTO;
import kr.jetstream.board.service.BoardService;
import kr.jetstream.card.dto.CardDTO;
import kr.jetstream.member.dto.MemberDTO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class BoardCalendarController {

	@Autowired
	BoardService service;
	
	@RequestMapping(value="/board/board_cal.do", method=RequestMethod.GET)
	public ModelAndView showPage(HttpSession session, String board_id){
		System.out.println("캘린더컨트롤"+board_id);
		List<CardDTO> cardList = service.selectCard(board_id);

		BoardDTO board = new BoardDTO();
		String member_id;
		String set_ok = "N";
		
		// 로그인이 안되어 있으면 그냥 보드 보기
		if (session.getAttribute("member") == null) {
			board = service.viewBoard(board_id);
			
		// 로그인이 되어있으면 세션에서 아이디 받음
		} else {
			MemberDTO member = (MemberDTO)session.getAttribute("member");
			member_id = member.getMember_id();

			BoardDTO dto = new BoardDTO();
			dto.setBoard_id(board_id);
			dto.setMember_id(member_id);
			board = service.viewMyBoard(dto);
			
			if(board == null) {
				board = service.viewBoard(board_id);

			} else {
				set_ok = "Y";
			}
		}

		
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
		mav.addObject("set_ok", set_ok);
		mav.addObject("datalist", datalist);

		return mav;
	}
}
