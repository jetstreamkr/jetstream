package kr.jetstream.checklist.service;

import java.util.List;

import kr.jetstream.checklist.dto.CheckListDTO;

public interface CheckListService {
	//체크리스트 생성
	void create(CheckListDTO dto);
	//체크리스트 목록 보기
	List<CheckListDTO> showlist(String card_id);
	//체크리스트 상태바꾸기
	void changeState(CheckListDTO dto, String state);
	void delete(String chklist_id);
}
