package kr.jetstream.checklist.dao;

import java.util.List;

import kr.jetstream.checklist.dto.CheckListDTO;

public interface CheckListDAO {
	//체크리스트 생성
	void create(CheckListDTO dto);
	//체크리스트 보여주기
	List<CheckListDTO> showlist(String card_id);
	//체크리스트 상태 바꾸기
	void changeState(CheckListDTO dto, String state);
	void delete(String chklist_id);

}
