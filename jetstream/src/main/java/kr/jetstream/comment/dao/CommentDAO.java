package kr.jetstream.comment.dao;

import kr.jetstream.comment.dto.CommentDTO;

public interface CommentDAO {
	//��� ����
	public void createComment(CommentDTO comment);
	
	//��� Ŭ����
	public void closeComment(String comment_id);
	
	//��� ���� ����
	public void updateComment(CommentDTO comment);
}
