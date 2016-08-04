package kr.jetstream.label.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.jetstream.card.dto.CardDTO;
import kr.jetstream.label.dto.LabelCardDTO;
import kr.jetstream.label.dto.LabelDTO;
import kr.jetstream.label.service.LabelService;

@Controller
public class SetLabelController {
	
	@Autowired
	LabelService labelService;
	
	@RequestMapping(value="/label/SetLabel.do", method=RequestMethod.POST)
	public ModelAndView labelAdd(String card_id,LabelDTO label){
		
		CardDTO card = labelService.getCardDTO(card_id);
		Map<String, String> map = new HashMap<String, String>();
		map.put("label_id", label.getLabel_id());
		map.put("board_id", card.getBoard_id());
		map.put("card_id", card.getCard_id());
		map.put("list_id", card.getList_id());
		
		ModelAndView mav = new ModelAndView();
		
		List<LabelDTO> labelList = labelService.getLabelList(card.getBoard_id());
		
		List<LabelCardDTO> labelCardList = labelService.getLabelCardList(card.getBoard_id());
		
		int flag =0;
		for(int i=0 ;i<labelCardList.size();i++){
			if(labelCardList.get(i).getBoard_id().equals(label.getBoard_id())){
				if(labelCardList.get(i).getList_id().equals(card.getList_id())){
					if(labelCardList.get(i).getCard_id().equals(card_id)){
						if(labelCardList.get(i).getLabel_id().equals(label.getLabel_id())){
							flag=1;
						}
					}
				}
			}
		}
		
		System.out.println("flag="+flag);
		if(flag==0){
			labelService.setLabel(map);
		}else{
			labelService.deleteLabel(map);
		}
		
		ArrayList<LabelDTO> addedlabelListDTO = new ArrayList<LabelDTO>();
		List<String> addedlabelList = labelService.getAddedlabelList(card_id);
		for(int i=0; i<addedlabelList.size();i++){
			addedlabelListDTO.add(labelService.getLabelDTO(addedlabelList.get(i)));
		}
		
		mav.addObject("card", card);
		mav.addObject("labelList", labelList);
		mav.addObject("addedlabelListDTO", addedlabelListDTO);
		mav.setViewName("card/card_view");
		
		return mav;
		
	}
}
