package kr.jetstream.checklist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.jetstream.checklist.dao.CheckListDAO;
import kr.jetstream.checklist.dto.CheckListDTO;

@Service
public class CheckListServiceImpl implements CheckListService{

	@Autowired
	CheckListDAO dao;
	
	@Override
	public void create(CheckListDTO dto) {
		dao.create(dto);
		
	}

	@Override
	public List<CheckListDTO> showlist(String card_id) {
		return dao.showlist(card_id);
	}

	@Override
	public void changeState(CheckListDTO dto,String state) {
		dao.changeState(dto, state);
	}

	@Override
	public void delete(String chklist_id) {
		dao.delete(chklist_id);
	}

}
