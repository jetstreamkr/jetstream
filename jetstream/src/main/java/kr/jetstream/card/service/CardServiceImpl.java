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
	
	// 카드 생성
	@Override
	public void createCard(CardDTO card) {
		dao.createCard(card);
	}
	
	// 카드 클로즈
	public void closeCard (String card_id){
		dao.closeCard(card_id);
	}
	
	// 카드 목록 조회
	@Override
	public List<CardDTO> cardList(String board_id, String option) {
		return dao.cardList(board_id, option);
	}
	
	//카드 이름, 내용 수정
	public void updateCard (CardDTO card){
		dao.updateCard(card);
	}
	
	//카드 검색
	@Override
	public CardDTO searchCard(String member_id, String card_nm) {
		return dao.searchCard(member_id, card_nm);
	}

	// 카드 보기
	@Override
	public CardDTO viewCard(String card_id) {
		return dao.viewCard(card_id);
	}
	
	// 카드 수정
	@Override
	public void setCard(CardDTO card) {
		dao.setCard(card);
	}

}
