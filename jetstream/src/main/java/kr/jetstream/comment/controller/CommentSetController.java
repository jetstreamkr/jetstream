package kr.jetstream.comment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.jetstream.comment.dto.CommentDTO;
import kr.jetstream.comment.service.CommentService;

@Controller
public class CommentSetController {
	@Autowired
	CommentService commentService;
	
	
	@RequestMapping(value="/board/comment_set.do", method=RequestMethod.POST)
	public String setComment(String comment_id, String comment_txt, String card_id) {
		
		CommentDTO comment = new CommentDTO();
		comment.setComment_id(comment_id);
		comment.setComment_txt(comment_txt);
		
		commentService.setComment(comment);
		
		return "redirect:/board/card_view.do?card_id=" + card_id;
	}
}
