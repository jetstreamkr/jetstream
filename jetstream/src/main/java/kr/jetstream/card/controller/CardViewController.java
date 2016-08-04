package kr.jetstream.card.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.jetstream.attach.dto.FileDTO;
import kr.jetstream.attach.service.AttachService;
import kr.jetstream.card.dto.CardDTO;
import kr.jetstream.card.service.CardService;
import kr.jetstream.checklist.dto.CheckListDTO;
import kr.jetstream.checklist.service.CheckListService;
import kr.jetstream.comment.dto.CommentDTO;
import kr.jetstream.comment.service.CommentService;
import kr.jetstream.label.dto.LabelDTO;
import kr.jetstream.label.service.LabelService;

@Controller
public class CardViewController {
	@Autowired
	CardService cardService;
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	LabelService labelService;
	
	@Autowired
	AttachService attachService;
	
	@Autowired
	CheckListService checkservice;
	
	
	@RequestMapping(value="/board/card_view.do", method=RequestMethod.POST)
	public ModelAndView viewCard(String card_id){
		ModelAndView mav = new ModelAndView();

		// 카드
		CardDTO card = cardService.viewCard(card_id);
		
		// 댓글
		List<CommentDTO> commentList = commentService.viewComment(card_id);
		
		// 체크리스트
		List<CheckListDTO> checkList = checkservice.showlist(card_id);
		int count=0;
		int percent=0;
	      int sum = checkList.size();
	      
	      for(int i=0;i<checkList.size();i++){
	         CheckListDTO check = checkList.get(i);
	         if(check.getChklist_st().equals("O")){
	            count++;
	         }
	      }
	      if(count==0){
	    	   percent = 0;
	      }else{
	    	   percent = (count*100)/sum;
	      }
	      
		
		// 파일 업로드
		List<FileDTO> fileList = attachService.list(card_id);
		System.out.println("card_id"+fileList.toString());
		//
		
		
		// 라벨
		List<LabelDTO> labelList = labelService.getLabelList(card.getBoard_id());
		System.out.println("labelList="+labelList.size());
		ArrayList<LabelDTO> addedlabelListDTO = new ArrayList<LabelDTO>();
		List<String> addedlabelList = labelService.getAddedlabelList(card_id);
		for(int i=0; i<addedlabelList.size();i++){
			addedlabelListDTO.add(labelService.getLabelDTO(addedlabelList.get(i)));
		}
		
		// 담당자
		
		mav.addObject("card", card);
		mav.addObject("checkList", checkList);
		mav.addObject("percent", percent);
		mav.addObject("commentList", commentList);
		mav.addObject("labelList", labelList);
		mav.addObject("addedlabelListDTO", addedlabelListDTO);
		mav.addObject("fileList", fileList);
		mav.setViewName("card/card_view");
		return mav;
	}
	
}
