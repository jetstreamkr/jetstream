package kr.jetstream.card.check.dao;

import java.util.List;

import kr.jetstream.card.check.dto.CheckListDTO;

public interface CheckListDAO {
	//üũ����Ʈ ����
	void create(CheckListDTO dto);
	//üũ����Ʈ �����ֱ�
	List<CheckListDTO> showlist(String board_id);
	//üũ����Ʈ ���� �ٲٱ�
	void changeState(CheckListDTO dto);

}
