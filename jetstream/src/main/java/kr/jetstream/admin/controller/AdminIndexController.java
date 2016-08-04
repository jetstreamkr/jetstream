package kr.jetstream.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.jetstream.admin.dto.ChartDTO;
import kr.jetstream.admin.service.AdminService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class AdminIndexController {

	@Autowired
	AdminService service;
	
	@RequestMapping(value = "/admin/index.do")
	public ModelAndView showPage(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/index");
		mav.addObject("readMember", service.readMember());
		mav.addObject("readBoard", service.readBoard());
		
		List<ChartDTO> chartdata = service.adminChart();
		JSONArray datalist = new JSONArray();
		JSONObject object;

		for(int i=0 ; i < chartdata.size() ;i++){
			object = new JSONObject();
			object.put("day", chartdata.get(i).getChart_day());
			object.put("member_cn", chartdata.get(i).getMember_cn());
			object.put("board_cn", chartdata.get(i).getBoard_cn());
			datalist.add(object);
		}
		mav.addObject("datalist", datalist);
		return mav;
	}
	
	
}
