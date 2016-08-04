package kr.jetstream.attach.dao;

import java.util.List;

import kr.jetstream.attach.dto.FileDTO;

public interface AttachDAO {
	void insert(FileDTO file);

	List<FileDTO> list(String card_id);

	void delete(String card_id, String file_path);
}
