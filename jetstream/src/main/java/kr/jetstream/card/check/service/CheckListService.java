package kr.jetstream.card.check.service;

import java.util.List;

import kr.jetstream.card.check.dto.CheckListDTO;

public interface CheckListService {
	//üũ����Ʈ ����
	void create(CheckListDTO dto);
	//üũ����Ʈ ��� ����
	List<CheckListDTO> showlist(String board_id);
	//üũ����Ʈ ���¹ٲٱ�
	void changeState(CheckListDTO dto);
}
