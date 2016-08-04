package kr.jetstream.card.dao;

import java.util.List;

import kr.jetstream.card.dto.AssignDTO;
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
	// 카드 시작일 수정
	public void setCardStart(CardDTO card);
	
	// 카드 종료일 수정
	public void setCardDue(CardDTO card);

	// 카드 제목 수정
	public void setCardNm(CardDTO card);
	
	// 카드 내용 수정
	public void setCardTxt(CardDTO card);
	
	// 카드 오더 수정
	public void setCardOrder(CardDTO card);

	
// 담당자
	// 담당자 조회
	public List<AssignDTO> viewAssign(String card_id);
	
	// 담당자 추가
	public void addAssign(AssignDTO assign);
	
	// 담당자 삭제
	public void closeAssign(AssignDTO assign);
	
	// 담당자 체크
	public void chkAssign(AssignDTO assign);

}
