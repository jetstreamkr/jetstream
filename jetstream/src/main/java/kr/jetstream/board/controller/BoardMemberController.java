package kr.jetstream.board.controller;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.jetstream.board.dto.BoardDTO;
import kr.jetstream.board.service.BoardService;
import kr.jetstream.member.dto.MemberDTO;

@Controller
public class BoardMemberController {
	@Autowired
	BoardService boardService;
	
	// GET으로 넘어올 경우 설정 폼 표출
	@RequestMapping(value="/board/board_member_search.do",method=RequestMethod.GET)
	public ModelAndView boardSearchMember(String keyword) throws UnsupportedEncodingException {
		
		ModelAndView mav = new ModelAndView();
		
		List<MemberDTO> memberList = boardService.searchBoardMember(URLDecoder.decode(keyword,"UTF-8"));
		System.out.println(memberList.toString());
		System.out.println(keyword);
		
		mav.addObject("memberList", memberList);
		mav.setViewName("board/search_member");
		return mav;
	}
	
	@RequestMapping(value="/board/board_member_add.do",method=RequestMethod.POST)
	public ModelAndView boardaddMember(String member_id, String board_id) {
		
		ModelAndView mav = new ModelAndView();
		
		BoardDTO board = new BoardDTO();
		board.setMember_id(member_id);
		board.setBoard_id(board_id);
		
		boardService.addBoardMember(board);
		
		mav.setViewName("redirect:/board/board_set.do?board_id=" + board_id);
		return mav;
	}
	
	@RequestMapping(value="/board/board_member_set.do",method=RequestMethod.POST)
	public ModelAndView boardPermitMember(String member_id, String member_permit, String board_id) {
		
		ModelAndView mav = new ModelAndView();
		
		BoardDTO board = new BoardDTO();
		board.setMember_id(member_id);
		board.setMember_permit(member_permit);
		board.setBoard_id(board_id);
		
		boardService.setBoardMember(board);
		
		mav.setViewName("redirect:/board/board_set.do?board_id=" + board_id);
		return mav;
	}
}
