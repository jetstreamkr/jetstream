package kr.jetstream.checklist.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.jetstream.checklist.dto.CheckListDTO;
import kr.jetstream.checklist.service.CheckListService;

@Controller
public class CheckCreateController {

	@Autowired
	CheckListService service;

	@RequestMapping(value = "/board/checkcreate.do", method = RequestMethod.POST)
	public void createChecklist(HttpServletRequest req, HttpServletResponse res, String board_id, String list_id,
			String card_id, String chklist_txt) throws Exception {

		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
		CheckListDTO dto = new CheckListDTO(board_id, list_id, card_id, chklist_txt);
		service.create(dto);
		List<CheckListDTO> list = service.showlist(card_id);
		PrintWriter pw = res.getWriter();
		for (int i = 0; i < list.size(); i++) {

			CheckListDTO chk = list.get(i);
			String chk_txt = chk.getChklist_txt();
			String chk_id = chk.getChklist_id();
			String chk_st = chk.getChklist_st();
			System.out.println(chk_st);

			if (chk_st.equals("O")) {
				pw.print("<div><input type='checkbox' name='chkbox' id='chkbox-" + chk_id
						+ "' class='chkbox-" + card_id + "' value='" + card_id + "," + chk_id
						+ "' checked/> " + chk_txt + " <button type='button' class='btn btn-default btn-xs' onclick='deleteCheck(&#39;" + card_id + "&#39;,&#39;" + chk_id
						+ "')&#39;><span class='fa fa-close'></span></button></div>");
			} else {
				pw.print("<div><input type='checkbox' name='chkbox' id='chkbox-" + chk_id
						+ "' class='chkbox-" + card_id + "' value='" + card_id + "," + chk_id
						+ "'/> " + chk_txt + " <button type='button' class='btn btn-default btn-xs' onclick='deleteCheck(&#39;" + card_id + "&#39;,&#39;" + chk_id
						+ "')&#39;><span class='fa fa-close'></span></button></div>");
			}
		}

	}
}
