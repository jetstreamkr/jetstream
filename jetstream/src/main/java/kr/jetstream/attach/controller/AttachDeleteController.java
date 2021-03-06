package kr.jetstream.attach.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.jetstream.attach.service.AttachService;

@Controller
public class AttachDeleteController {
	
	@Autowired
	AttachService service;
	
	@RequestMapping("board/attachdelete.do")
	public ModelAndView delete(String board_id,String card_id,String file_path){
		ModelAndView mav = new ModelAndView();
		service.delete(card_id,file_path);
		mav.setViewName("redirect:/board/board_list.do?board_id="+board_id);
		return mav;
	}

}
