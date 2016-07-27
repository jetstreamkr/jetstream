package kr.jetstream.pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.jetstream.pack.dto.PackDTO;
import kr.jetstream.pack.service.PackService;

@Controller
public class PackCreateController {
	@Autowired
	PackService service;
	
	@RequestMapping(value="/board/pack_create.do", method=RequestMethod.POST)
	public String creatPack(PackDTO pack){
		
		service.createList(pack);
		
		return "redirect:/board/board_list.do?board_id=" + pack.getBoard_id();
		
	}
}
