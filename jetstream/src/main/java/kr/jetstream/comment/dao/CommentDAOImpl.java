package kr.jetstream.comment.dao;

import java.util.List;

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

	// ��� ����
	@Override
	public List<CommentDTO> viewComment(String card_id) {
		return sqlssesion.selectList("viewComment", card_id);
	}
	
	//��� Ŭ����
	@Override
	public void closeComment(String comment_id) {
		sqlssesion.update("closeComment", comment_id);

	}

	//��� �������
	@Override
	public void setComment(CommentDTO comment) {
		sqlssesion.update("setComment", comment);
		
	}

}
