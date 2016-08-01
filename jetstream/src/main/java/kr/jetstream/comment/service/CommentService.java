package kr.jetstream.comment.service;

import kr.jetstream.comment.dto.CommentDTO;

public interface CommentService {
	
	//��� ����
	public void createComment(CommentDTO comment);
	
	//��� Ŭ����
	public void closeComment(String comment_id);
	
	//��� ���� ����
	public void updateComment(CommentDTO comment);
}
