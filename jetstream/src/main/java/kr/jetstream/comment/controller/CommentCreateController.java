package kr.jetstream.comment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.jetstream.comment.dto.CommentDTO;
import kr.jetstream.comment.service.CommentService;

@Controller
public class CommentCreateController {
	@Autowired
	CommentService commentService;
	
	
	@RequestMapping(value="/board/comment_create.do", method=RequestMethod.POST)
	public String creatComment(CommentDTO comment) {
		commentService.createComment(comment);
		return "redirect:/board/board_list.do?board_id=" + comment.getBoard_id();
	}
}
