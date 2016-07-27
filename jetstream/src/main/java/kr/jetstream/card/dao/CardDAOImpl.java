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
	public List<CardDTO> cardList(String board_id) {
		return sqlsession.selectList("cardList", board_id);
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

}
