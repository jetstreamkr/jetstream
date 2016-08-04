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
<<<<<<< HEAD
	public String creatComment(String board_id, String card_id, String list_id, String member_id, String comment_txt) {
		
		CommentDTO comment = new CommentDTO();
		comment.setBoard_id(board_id);
		comment.setCard_id(card_id);
		comment.setList_id(list_id);
		comment.setMember_id(member_id);
		comment.setComment_txt(comment_txt);
		
		commentService.createComment(comment);
		
		return "redirect:/board/card_view.do?card_id=" + comment.getCard_id();
	}
}
=======
	public String creatComment(CommentDTO comment) {
		commentService.createComment(comment);
		return "redirect:/board/board_list.do?board_id=" + comment.getBoard_id();
	}
}
>>>>>>> refs/remotes/origin/jisung
