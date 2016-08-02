package kr.jetstream.card.check.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.jetstream.card.check.dao.CheckListDAO;
import kr.jetstream.card.check.dto.CheckListDTO;

@Service
public class CheckListServiceImpl implements CheckListService{

	@Autowired
	CheckListDAO dao;
	
	@Override
	public void create(CheckListDTO dto) {
		dao.create(dto);
		
	}

	@Override
	public List<CheckListDTO> showlist(String board_id) {
		return dao.showlist(board_id);
	}

	@Override
	public void changeState(CheckListDTO dto) {
		dao.changeState(dto);
	}

}
