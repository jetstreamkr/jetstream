package kr.jetstream.comment.dao;

import java.util.List;

import kr.jetstream.comment.dto.CommentDTO;

public interface CommentDAO {
	
	
	//´ñ±Û »ý¼º
	public void createComment(CommentDTO comment);
	
	//´ñ±Û º¸±â
	public List<CommentDTO> viewComment(String card_id);
	
	//´ñ±Û ³»¿ë ¼öÁ¤
	public void setComment(CommentDTO comment);
	
	//´ñ±Û Å¬·ÎÁî
	public void closeComment(String comment_id);
	
}
