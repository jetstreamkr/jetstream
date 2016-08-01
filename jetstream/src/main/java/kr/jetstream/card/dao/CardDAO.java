package kr.jetstream.card.dao;

import java.util.List;

import kr.jetstream.card.dto.CardDTO;

public interface CardDAO {

	// ī�� ����
	public void createCard(CardDTO card);

	// ī�� Ŭ����
	public void closeCard(String card_id);
	
	// ī�� ��� ��ȸ
	public List<CardDTO> cardList(String board_id);

	// ī�� �̸�, ���� ����
	public void updateCard(CardDTO card);

	// ī�� �˻�
	public CardDTO searchCard(String member_id, String card_nm);
}
