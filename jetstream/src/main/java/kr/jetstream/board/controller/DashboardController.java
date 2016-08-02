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
		
		// �α����� �ȵǾ� ������ �ε����� �����̷�Ʈ
		if (session.getAttribute("member") == null) {
			ref = "redirect:/index.do";
		
		// �α����� �Ǿ������� ���ǿ��� ���̵� ���� - ���������̹Ƿ� �������� ó��
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
