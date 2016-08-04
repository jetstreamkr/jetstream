package kr.jetstream.card.dao;

import java.util.List;

import kr.jetstream.card.dto.AssignDTO;
import kr.jetstream.card.dto.CardDTO;

public interface CardDAO {

	// ī�� ����
	public void createCard(CardDTO card);

	// ī�� Ŭ����
	public void closeCard(String card_id);
	
	// ī�� ��� ��ȸ
	public List<CardDTO> cardList(String board_id, String option);

	// ī�� �̸�, ���� ����
	public void updateCard(CardDTO card);

	// ī�� �˻�
	public CardDTO searchCard(String member_id, String card_nm);
	
	// ī�� ����(card_view.do)
	public CardDTO viewCard(String card_id);
	
// ī�� ����
	// ī�� ������ ����
	public void setCardStart(CardDTO card);
	
	// ī�� ������ ����
	public void setCardDue(CardDTO card);

	// ī�� ���� ����
	public void setCardNm(CardDTO card);
	
	// ī�� ���� ����
	public void setCardTxt(CardDTO card);
	
	// ī�� ���� ����
	public void setCardOrder(CardDTO card);

	
// �����
	// ����� ��ȸ
	public List<AssignDTO> viewAssign(String card_id);
	
	// ����� �߰�
	public void addAssign(AssignDTO assign);
	
	// ����� ����
	public void closeAssign(AssignDTO assign);
	
	// ����� üũ
	public void chkAssign(AssignDTO assign);

}
