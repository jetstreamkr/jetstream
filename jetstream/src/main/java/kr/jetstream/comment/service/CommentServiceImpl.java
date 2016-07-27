package kr.jetstream.comment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.jetstream.comment.dao.CommentDAO;
import kr.jetstream.comment.dto.CommentDTO;
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDAO dao;
	
	//댓글 생성
	@Override
	public void createComment(CommentDTO comment) {
		dao.createComment(comment);
	}

	//댓글 클로즈
	@Override
	public void closeComment(String comment_id) {
		dao.closeComment(comment_id);

	}

	//댓글 내용수정
	@Override
	public void updateComment(CommentDTO comment) {
		dao.updateComment(comment);

	}

}
