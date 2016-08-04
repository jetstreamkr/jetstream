package kr.jetstream.comment.service;

import java.util.List;

import kr.jetstream.comment.dto.CommentDTO;

public interface CommentService {
	
	//��� ����
	public void createComment(CommentDTO comment);
	
	//��� ����
	public List<CommentDTO> viewComment(String card_id);
	
	//��� ���� ����
	public void setComment(CommentDTO comment);
	
	//��� Ŭ����
	public void closeComment(String comment_id);
	
}
