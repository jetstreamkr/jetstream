package kr.jetstream.card.dao;

import java.util.List;

import kr.jetstream.card.dto.CardDTO;

public interface CardDAO {

	// 카드 생성
	public void createCard(CardDTO card);

	// 카드 클로즈
	public void closeCard(String card_id);
	
	// 카드 목록 조회
	public List<CardDTO> cardList(String board_id, String option);

	// 카드 이름, 내용 수정
	public void updateCard(CardDTO card);

	// 카드 검색
	public CardDTO searchCard(String member_id, String card_nm);
	
	// 카드 보기(card_view.do)
	public CardDTO viewCard(String card_id);
	
	// 카드 수정
	public void setCard(CardDTO card);
}
