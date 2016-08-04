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
import kr.jetstream.board.service.BoardService;
import kr.jetstream.card.dto.AssignDTO;
import kr.jetstream.card.dto.CardDTO;
import kr.jetstream.card.service.CardService;
import kr.jetstream.checklist.dto.CheckListDTO;
import kr.jetstream.checklist.service.CheckListService;
import kr.jetstream.comment.dto.CommentDTO;
import kr.jetstream.comment.service.CommentService;
import kr.jetstream.label.dto.LabelDTO;
import kr.jetstream.label.service.LabelService;
import kr.jetstream.member.dto.MemberDTO;

@Controller
public class CardViewController {
	@Autowired
	CardService cardService;
	
	@Autowired
	BoardService boardService;

	@Autowired
	LabelService labelService;
	
	@Autowired
	AttachService attachService;
	
	@Autowired
	CheckListService checkservice;
	
	@Autowired
	CommentService commentService;
	
	@RequestMapping(value="/board/card_view.do", method=RequestMethod.GET)
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
		List<AssignDTO> assignList = cardService.viewAssign(card_id);
		System.out.println(card_id + assignList.toString());
		
		// 멤버목록
		// 보드 멤버 보기
		List<MemberDTO> boardMemberList = boardService.viewBoardMember(card.getBoard_id());
		
		mav.addObject("card", card);
		mav.addObject("checkList", checkList);
		mav.addObject("percent", percent);
		mav.addObject("commentList", commentList);
		mav.addObject("labelList", labelList);
		mav.addObject("addedlabelListDTO", addedlabelListDTO);
		mav.addObject("fileList", fileList);
		mav.addObject("assignList", assignList);
		mav.addObject("boardMemberList", boardMemberList);
		mav.setViewName("card/card_view");
		return mav;
	}
	
}
