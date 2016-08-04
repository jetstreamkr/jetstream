package kr.jetstream.label.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.jetstream.card.dto.CardDTO;
import kr.jetstream.label.dao.LabelDAO;
import kr.jetstream.label.dto.LabelCardDTO;
import kr.jetstream.label.dto.LabelDTO;
@Service
public class LabelServiceImpl implements LabelService {
	
	@Autowired
	LabelDAO dao;

	@Override
	public void createLabel(String board_id) {
		dao.createLabel(board_id);		
	}

	@Override
	public List<LabelDTO> getLabelList(String board_id) {
		return dao.getLabelList(board_id);
	}

	@Override
	public CardDTO getCardDTO(String card_id) {
		return dao.getCardDTO(card_id);
	}

	@Override
	public void setLabel(Map<String, String> map) {
		dao.setLabel(map);
	}

	@Override
	public List<String> getAddedlabelList(String card_id) {
		return dao.getAddedlabelList(card_id);
	}

	@Override
	public LabelDTO getLabelDTO(String label_id) {
		return dao.getLabelDTO(label_id);
	}

	@Override
	public List<LabelCardDTO> getLabelCardList(String board_id) {
		return dao.getLabelCardList(board_id);
	}

	@Override
	public void deleteLabel(Map<String, String> map) {
		dao.deleteLabel(map);
	}






	
}
