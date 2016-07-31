package kr.jetstream.card.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.jetstream.card.dao.CardDAO;
import kr.jetstream.card.dto.CardDTO;
@Service
public class CardServiceImpl implements CardService {

	@Autowired
	CardDAO dao;
	
	// ī�� ����
	@Override
	public void createCard(CardDTO card) {
		dao.createCard(card);
	}
	
	// ī�� Ŭ����
	public void closeCard (String card_id){
		dao.closeCard(card_id);
	}
	
	// ī�� ��� ��ȸ
	@Override
	public List<CardDTO> cardList(String board_id, String option) {
		return dao.cardList(board_id, option);
	}
	
	//ī�� �̸�, ���� ����
	public void updateCard (CardDTO card){
		dao.updateCard(card);
	}
	
	//ī�� �˻�
	@Override
	public CardDTO searchCard(String member_id, String card_nm) {
		return dao.searchCard(member_id, card_nm);
	}

	// ī�� ����
	@Override
	public CardDTO viewCard(String card_id) {
		return dao.viewCard(card_id);
	}
	
	// ī�� ����
	@Override
	public void setCard(CardDTO card) {
		dao.setCard(card);
	}

}
