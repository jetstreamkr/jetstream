package kr.jetstream.label.service;

import java.util.List;
import java.util.Map;

import kr.jetstream.card.dto.CardDTO;
import kr.jetstream.label.dto.LabelCardDTO;
import kr.jetstream.label.dto.LabelDTO;

public interface LabelService {
	
	void createLabel(String board_id);

	List<LabelDTO> getLabelList(String board_id);

	CardDTO getCardDTO(String card_id);

	void setLabel(Map<String, String> map);

	List<String> getAddedlabelList(String card_id);

	LabelDTO getLabelDTO(String label_id);

	List<LabelCardDTO> getLabelCardList(String board_id);

	void deleteLabel(Map<String, String> map);

}
