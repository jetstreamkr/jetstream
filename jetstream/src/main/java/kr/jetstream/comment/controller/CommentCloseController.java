package kr.jetstream.comment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.jetstream.comment.dto.CommentDTO;
import kr.jetstream.comment.service.CommentService;

@Controller
public class CommentCloseController {
	@Autowired
	CommentService commentService;
	
	
	@RequestMapping(value="/board/comment_close.do", method=RequestMethod.POST)
	public String closeComment(String comment_id, String card_id) {
		commentService.closeComment(comment_id);
		
		return "redirect:/board/card_view.do?card_id=" + card_id;

	}
}
