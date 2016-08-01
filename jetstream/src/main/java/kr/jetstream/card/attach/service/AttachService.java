package kr.jetstream.card.attach.service;

import java.util.List;

import kr.jetstream.card.attach.dto.FileDTO;

public interface AttachService {
	void insert(FileDTO file);
	List<FileDTO> list(String board_id);
	void delete(String card_id, String file_path);
}
