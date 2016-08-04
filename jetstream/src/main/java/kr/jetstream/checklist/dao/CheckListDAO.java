package kr.jetstream.checklist.dao;

import java.util.List;

import kr.jetstream.checklist.dto.CheckListDTO;

public interface CheckListDAO {
	//üũ����Ʈ ����
	void create(CheckListDTO dto);
	//üũ����Ʈ �����ֱ�
	List<CheckListDTO> showlist(String card_id);
	//üũ����Ʈ ���� �ٲٱ�
	void changeState(CheckListDTO dto, String state);
	void delete(String chklist_id);

}
