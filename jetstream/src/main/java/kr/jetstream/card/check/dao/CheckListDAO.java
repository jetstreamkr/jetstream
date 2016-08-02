package kr.jetstream.card.check.dao;

import java.util.List;

import kr.jetstream.card.check.dto.CheckListDTO;

public interface CheckListDAO {
	//체크리스트 생성
	void create(CheckListDTO dto);
	//체크리스트 보여주기
	List<CheckListDTO> showlist(String board_id);
	//체크리스트 상태 바꾸기
	void changeState(CheckListDTO dto);

}
