package kr.jetstream.comment.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.jetstream.comment.dto.CommentDTO;
@Repository("commentdao")
public class CommentDAOImpl implements CommentDAO {

	@Autowired
	SqlSession sqlssesion;
	//��� ����
	@Override
	public void createComment(CommentDTO comment) {
		sqlssesion.insert("createComment", comment);

	}

	//��� Ŭ����
	@Override
	public void closeComment(String comment_id) {
		sqlssesion.update("closeComment", comment_id);

	}

	//��� �������
	@Override
	public void updateComment(CommentDTO comment) {
		sqlssesion.update("updateComment", comment);

	}

}
