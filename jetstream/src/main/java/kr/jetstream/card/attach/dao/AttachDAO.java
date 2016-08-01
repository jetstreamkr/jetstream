package kr.jetstream.card.attach.dao;

import java.util.List;

import kr.jetstream.card.attach.dto.FileDTO;

public interface AttachDAO {
	void insert(FileDTO file);

	List<FileDTO> list(String board_id);

	void delete(String card_id, String file_path);
}
