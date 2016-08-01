package kr.jetstream.card.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.jetstream.card.dto.CardDTO;

@Repository("carddao")
public class CardDAOImpl implements CardDAO {
	@Autowired
	SqlSession sqlsession;
	
	//ī�� ����
	@Override
	public void createCard(CardDTO card) {
		sqlsession.insert("createCard",card);
		
	}
	
	// ī�� Ŭ����
	public void closeCard(String card_id){
		sqlsession.update("closeCard", card_id);
	}
	
	// ī�� ��� ��ȸ
	@Override
	public List<CardDTO> cardList(String board_id) {
		return sqlsession.selectList("cardList", board_id);
	}
	
	
	//ī�� �̸�, ���� ����
	public void updateCard (CardDTO card){
		sqlsession.update("updateCard",card);
	}
	
	//ī�� �˻�
	@Override
	public CardDTO searchCard(String member_id, String card_nm) {
		
		return (CardDTO) sqlsession.selectMap("searchCard", member_id, card_nm);
	}

}
