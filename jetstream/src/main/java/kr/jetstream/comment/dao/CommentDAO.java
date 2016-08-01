package kr.jetstream.comment.dao;

import kr.jetstream.comment.dto.CommentDTO;

public interface CommentDAO {
	//댓글 생성
	public void createComment(CommentDTO comment);
	
	//댓글 클로즈
	public void closeComment(String comment_id);
	
	//댓글 내용 수정
	public void updateComment(CommentDTO comment);
}
