package kr.jetstream.checklist.service;

import java.util.List;

import kr.jetstream.checklist.dto.CheckListDTO;

public interface CheckListService {
	//üũ����Ʈ ����
	void create(CheckListDTO dto);
	//üũ����Ʈ ��� ����
	List<CheckListDTO> showlist(String card_id);
	//üũ����Ʈ ���¹ٲٱ�
	void changeState(CheckListDTO dto, String state);
	void delete(String chklist_id);
}
