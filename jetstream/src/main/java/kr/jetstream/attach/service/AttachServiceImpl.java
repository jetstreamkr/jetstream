package kr.jetstream.attach.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.jetstream.attach.dao.AttachDAO;
import kr.jetstream.attach.dto.FileDTO;

@Service
public class AttachServiceImpl implements AttachService {

	@Autowired
	AttachDAO dao;
	
	@Override
	public void insert(FileDTO file) {
		dao.insert(file);
	}

	@Override
	public List<FileDTO> list(String card_id) {
		return dao.list(card_id);
	}

	@Override
	public void delete(String card_id, String file_path) {
		dao.delete(card_id,file_path);
		
	}


}
