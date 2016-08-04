package kr.jetstream.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.jetstream.board.dto.BoardDTO;
import kr.jetstream.board.service.BoardService;
import kr.jetstream.member.dto.MemberDTO;

@Controller
public class DashboardController {
	@Autowired
	BoardService service;

	@RequestMapping(value = "/dashboard.do")
	public ModelAndView getDashboard(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		String ref = null;
		
		// 로그인이 안되어 있으면 인덱스로 리다이렉트
		if (session.getAttribute("member") == null) {
			ref = "redirect:/index.do";
		
		// 로그인이 되어있으면 세션에서 아이디 받음 - 개인정보이므로 세션으로 처리
		} else {
			MemberDTO member = (MemberDTO)session.getAttribute("member");
			String member_id = member.getMember_id();
			List<BoardDTO> boardList = service.dashboard(member_id);
			List<BoardDTO> favBoardList = service.favdashboard(member_id);

			mav.addObject("boardList", boardList);
			mav.addObject("favBoardList", favBoardList);

		}
		
		mav.setViewName(ref);
		return mav;
	}
}
