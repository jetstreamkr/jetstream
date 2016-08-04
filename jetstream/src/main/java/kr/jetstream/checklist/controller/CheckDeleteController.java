package kr.jetstream.checklist.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.jetstream.checklist.dto.CheckListDTO;
import kr.jetstream.checklist.service.CheckListService;

@Controller
public class CheckDeleteController {

	@Autowired
	CheckListService service;

	@RequestMapping("/board/checkdelete.do")
	public void delete(HttpServletRequest req, HttpServletResponse res, String card_id, String chklist_id)
			throws Exception {
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
		service.delete(chklist_id);

		List<CheckListDTO> list = service.showlist(card_id);
		PrintWriter pw = res.getWriter();
		for (int i = 0; i < list.size(); i++) {

			CheckListDTO chk = list.get(i);
			String chk_txt = chk.getChklist_txt();
			String chk_id = chk.getChklist_id();
			String chk_st = chk.getChklist_st();
			System.out.println(chk_st);

			if (chk_st.equals("O")) {
				pw.print("<div>" + chk_txt + "  <input type='checkbox' name='chkbox' id='chkbox-" + chk_id
						+ "' class='chkbox-" + card_id + "' value='" + card_id + "," + chk_id
						+ "' checked/><input type='button' value='x' onclick='deleteCheck(&#39;" + card_id + "&#39;,&#39;" + chk_id
						+ "&#39;)'></div>");
			} else {
				pw.print("<div>" + chk_txt + "  <input type='checkbox' name='chkbox' id='chkbox-" + chk_id
						+ "' class='chkbox-" + card_id + "' value='" + card_id + "," + chk_id
						+ "'/><input type='button' value='x' onclick='deleteCheck(&#39;" + card_id + "&#39;,&#39;" + chk_id
						+ "&#39;)'></div>");
			}

		}
	}

}
