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
import kr.jetstream.member.dto.MemberDTO;

@Controller
public class BoardFavController {
	@Autowired
	BoardService service;
	
	@RequestMapping(value="/board/board_fav.do", method=RequestMethod.POST)
	public ModelAndView favBoard(HttpSession session,String board_id){
		System.out.println("연결성공");
		System.out.println("board_id="+board_id);
		String boardFavSt=service.findBoardfav(board_id);
		System.out.println("boardFavSt="+boardFavSt);
		if(boardFavSt.equals("N")){
			service.setBoardfavToY(board_id);
		}else{
			service.setBoardfavToN(board_id);
		}
		
		ModelAndView mav = new ModelAndView();
		MemberDTO member = (MemberDTO)session.getAttribute("member");
		String member_id = member.getMember_id();
		List<BoardDTO> boardList = service.dashboard(member_id);
		List<BoardDTO> favboardList = service.favdashboard(member_id);
		mav.addObject("favBoardList", favboardList);
		mav.addObject("boardList", boardList);
		mav.setViewName("board/dashboard");
		
		return mav;
	}
}
