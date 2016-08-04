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
	
	
	//´ñ±Û »ý¼º
	@Override
	public void createComment(CommentDTO comment) {
		sqlssesion.insert("createComment", comment);
	}

	// ´ñ±Û º¸±â
	@Override
	public List<CommentDTO> viewComment(String card_id) {
		return sqlssesion.selectList("viewComment", card_id);
	}
	
	//´ñ±Û Å¬·ÎÁî
	@Override
	public void closeComment(String comment_id) {
		sqlssesion.update("closeComment", comment_id);

	}

	//´ñ±Û ³»¿ë¼öÁ¤
	@Override
	public void setComment(CommentDTO comment) {
		sqlssesion.update("setComment", comment);
		
	}

}
