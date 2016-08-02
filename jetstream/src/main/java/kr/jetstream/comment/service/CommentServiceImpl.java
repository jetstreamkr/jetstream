package kr.jetstream.comment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.jetstream.comment.dao.CommentDAO;
import kr.jetstream.comment.dto.CommentDTO;
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDAO dao;
	
	//´ñ±Û »ý¼º
	@Override
	public void createComment(CommentDTO comment) {
		dao.createComment(comment);
	}
	
	//´ñ±Û º¸±â 
	@Override
	public List<CommentDTO> viewComment(String card_id) {
		return dao.viewComment(card_id);
	}	

	//´ñ±Û Å¬·ÎÁî
	@Override
	public void closeComment(String comment_id) {
		dao.closeComment(comment_id);
	}

	//´ñ±Û ³»¿ë¼öÁ¤
	@Override
	public void setComment(CommentDTO comment) {
		dao.setComment(comment);
	}

}
