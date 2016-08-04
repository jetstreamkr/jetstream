package kr.jetstream.label.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.jetstream.card.dto.CardDTO;
import kr.jetstream.label.dto.LabelCardDTO;
import kr.jetstream.label.dto.LabelDTO;
@Repository("labeldao")
public class LabelDAOImpl implements LabelDAO {

	@Autowired
	SqlSession sqlssesion;

	@Override
	public void createLabel(String board_id) {
		sqlssesion.insert("jetstream.label.createLabel1",board_id);
		sqlssesion.insert("jetstream.label.createLabel2",board_id);
		sqlssesion.insert("jetstream.label.createLabel3",board_id);
		sqlssesion.insert("jetstream.label.createLabel4",board_id);
		sqlssesion.insert("jetstream.label.createLabel5",board_id);
		sqlssesion.insert("jetstream.label.createLabel6",board_id);
	}

	@Override
	public List<LabelDTO> getLabelList(String board_id) {
		return sqlssesion.selectList("jetstream.label.getLabelList",board_id);
	}

	@Override
	public CardDTO getCardDTO(String card_id) {
		return sqlssesion.selectOne("jetstream.label.getCardDTO", card_id);
	}

	@Override
	public void setLabel(Map<String, String> map) {
		sqlssesion.insert("jetstream.label.setLabel",map);
	}

	@Override
	public List<String> getAddedlabelList(String card_id) {
		return sqlssesion.selectList("jetstream.label.getAddedlabelList",card_id);
	}

	@Override
	public LabelDTO getLabelDTO(String label_id) {
		return sqlssesion.selectOne("jetstream.label.getLabelDTO", label_id);
	}

	@Override
	public List<LabelCardDTO> getLabelCardList(String board_id) {
		return sqlssesion.selectList("jetstream.label.getLabelCardList",board_id);
	}

	@Override
	public void deleteLabel(Map<String, String> map) {
		sqlssesion.delete("jetstream.label.deleteLabel",map);
	}




}
