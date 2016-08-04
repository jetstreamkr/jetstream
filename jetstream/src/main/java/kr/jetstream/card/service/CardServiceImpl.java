package kr.jetstream.card.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.jetstream.card.dao.CardDAO;
import kr.jetstream.card.dto.AssignDTO;
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
	
<<<<<<< HEAD
// ī�� ����
	// ī�� ������ ����
	public void setCardStart(CardDTO card) {
		dao.setCardStart(card);
	}
	
	// ī�� ������ ����
	public void setCardDue(CardDTO card) {
		dao.setCardDue(card);
	}
	
	// ī�� ���� ����
	public void setCardNm(CardDTO card) {
		dao.setCardNm(card);
	}
	
	// ī�� ���� ����
	public void setCardTxt(CardDTO card) {
		dao.setCardTxt(card);
	}
	
	// ī�� ���� ����
	public void setCardOrder(CardDTO card) {
		dao.setCardOrder(card);
	}
	
// �����
	// ����� ��ȸ
	public List<AssignDTO> viewAssign(String card_id) {
		System.out.println("SER"+card_id);
		return dao.viewAssign(card_id);
	}
	
	// ����� �߰�
	public void addAssign(AssignDTO assign) {
		dao.addAssign(assign);
	}
	
	// ����� ����
	public void closeAssign(AssignDTO assign) {
		dao.closeAssign(assign);
	}
	
	// ����� üũ
	public void chkAssign(AssignDTO assign) {
		dao.chkAssign(assign);
	}

=======
	// ī�� ����
	@Override
	public void setCard(CardDTO card) {
		dao.setCard(card);
	}
>>>>>>> refs/remotes/origin/jisung

}
