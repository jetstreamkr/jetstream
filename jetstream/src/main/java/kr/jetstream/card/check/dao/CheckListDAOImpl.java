package kr.jetstream.card.check.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.jetstream.card.check.dto.CheckListDTO;

@Repository
public class CheckListDAOImpl implements CheckListDAO {

	@Autowired
	SqlSession sqlsession;
	
	@Override
	public void create(CheckListDTO dto) {
		sqlsession.insert("jetstream.card.checkcreate",dto);
	}
	
	@Override
	public List<CheckListDTO> showlist(String board_id) {
		return sqlsession.selectList("jetstream.card.checkselect",board_id);
	}

	@Override
	public void changeState(CheckListDTO dto) {
		sqlsession.update("jetstream.card.checkstate", dto);
		
	}
	
	

}
