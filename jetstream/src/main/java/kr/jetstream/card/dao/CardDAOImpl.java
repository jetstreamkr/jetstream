package kr.jetstream.card.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.jetstream.card.dto.AssignDTO;
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
	public List<CardDTO> cardList(String board_id, String option) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("board_id", board_id);
		map.put("option", option);
		
		return sqlsession.selectList("cardList", map);
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

	// ī�� ����
	@Override
	public CardDTO viewCard(String card_id) {
		return sqlsession.selectOne("viewCard", card_id);
	}
	
// ī�� ����
	// ī�� ������ ����
	public void setCardStart(CardDTO card) {
		sqlsession.update("setCardStart", card);
	}
	
	// ī�� ������ ����
	public void setCardDue(CardDTO card) {
		sqlsession.update("setCardDue", card);
	}

	// ī�� ���� ����
	public void setCardNm(CardDTO card) {
		sqlsession.update("setCardNm", card);
	}
	
	// ī�� ���� ����
	public void setCardTxt(CardDTO card) {
		sqlsession.update("setCardTxt", card);
	}

	// ī�� ���� ����
	public void setCardOrder(CardDTO card) {
		sqlsession.update("setCardOrder", card);
	}
	
// �����
	// ����� ��ȸ
	@Override
	public List<AssignDTO> viewAssign(String card_id) {
		return sqlsession.selectList("viewAssign", card_id);
	}

	// ����� �߰�
	@Override
	public void addAssign(AssignDTO assign) {
		sqlsession.insert("addAssign", assign);
	}

	// ����� ����
	@Override
	public void closeAssign(AssignDTO assign) {
		sqlsession.delete("closeAssign", assign);
	}

	// ����� üũ
	@Override
	public void chkAssign(AssignDTO assign) {
		sqlsession.update("chkAssign", assign);
	}
}
