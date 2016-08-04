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
	
	//카드 생성
	@Override
	public void createCard(CardDTO card) {
		sqlsession.insert("createCard",card);
	}
	
	// 카드 클로즈
	public void closeCard(String card_id){
		sqlsession.update("closeCard", card_id);
	}
	
	// 카드 목록 조회
	@Override
	public List<CardDTO> cardList(String board_id, String option) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("board_id", board_id);
		map.put("option", option);
		
		return sqlsession.selectList("cardList", map);
	}	
	
	//카드 이름, 내용 수정
	public void updateCard (CardDTO card){
		sqlsession.update("updateCard",card);
	}
	
	//카드 검색
	@Override
	public CardDTO searchCard(String member_id, String card_nm) {
		return (CardDTO) sqlsession.selectMap("searchCard", member_id, card_nm);
	}

	// 카드 보기
	@Override
	public CardDTO viewCard(String card_id) {
		return sqlsession.selectOne("viewCard", card_id);
	}
	
// 카드 수정
	// 카드 시작일 수정
	public void setCardStart(CardDTO card) {
		sqlsession.update("setCardStart", card);
	}
	
	// 카드 종료일 수정
	public void setCardDue(CardDTO card) {
		sqlsession.update("setCardDue", card);
	}

	// 카드 내용 수정
	public void setCardNm(CardDTO card) {
		sqlsession.update("setCardNm", card);
	}
	
	// 카드 내용 수정
	public void setCardTxt(CardDTO card) {
		sqlsession.update("setCardTxt", card);
	}

	// 카드 오더 수정
	public void setCardOrder(CardDTO card) {
		sqlsession.update("setCardOrder", card);
	}
	
// 담당자
	// 담당자 조회
	@Override
	public List<AssignDTO> viewAssign(String card_id) {
		return sqlsession.selectList("viewAssign", card_id);
	}

	// 담당자 추가
	@Override
	public void addAssign(AssignDTO assign) {
		sqlsession.insert("addAssign", assign);
	}

	// 담당자 삭제
	@Override
	public void closeAssign(AssignDTO assign) {
		sqlsession.delete("closeAssign", assign);
	}

	// 담당자 체크
	@Override
	public void chkAssign(AssignDTO assign) {
		sqlsession.update("chkAssign", assign);
	}
}
