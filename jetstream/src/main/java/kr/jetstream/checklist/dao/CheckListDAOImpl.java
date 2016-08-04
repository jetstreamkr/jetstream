package kr.jetstream.checklist.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.jetstream.checklist.dto.CheckListDTO;

@Repository
public class CheckListDAOImpl implements CheckListDAO {

	@Autowired
	SqlSession sqlsession;
	
	@Override
	public void create(CheckListDTO dto) {
		sqlsession.insert("jetstream.card.checkcreate",dto);
	}
	
	@Override
	public List<CheckListDTO> showlist(String card_id) {
		return sqlsession.selectList("jetstream.card.checkselect",card_id);
	}

	@Override
	public void changeState(CheckListDTO dto, String state){
		if(state.equals("1")){
			sqlsession.update("jetstream.card.checkstate", dto);
		}else if(state.equals("0")){
			sqlsession.update("jetstream.card.checkstate2", dto);
		}
		
	}

	@Override
	public void delete(String chklist_id) {
		sqlsession.delete("jetstream.card.checkdelete", chklist_id);
		
	}
	
	

}
