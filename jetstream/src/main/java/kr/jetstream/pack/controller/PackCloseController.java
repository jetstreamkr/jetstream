package kr.jetstream.pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.jetstream.pack.service.PackService;

@Controller
public class PackCloseController {

	@Autowired
	PackService service;
	
	
	@RequestMapping(value="/board/pack_close.do", method=RequestMethod.GET)
	public String closePack(String pack_id, String board_id){
		
		service.closePack(pack_id);

		return "redirect:/board/board_list.do?board_id="+board_id;
	}
}
