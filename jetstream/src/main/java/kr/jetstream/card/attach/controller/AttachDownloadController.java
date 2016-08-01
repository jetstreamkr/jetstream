package kr.jetstream.card.attach.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

@Controller
public class AttachDownloadController {

	@RequestMapping(value = "board/attachdownload.do", method = RequestMethod.GET)
	public void download(HttpServletRequest req, HttpServletResponse res, String board_id, String card_id, String file_path) {

		try {
			String path = WebUtils.getRealPath(req.getSession().getServletContext(), "/resources/files");
			byte fileByte[] = FileUtils.readFileToByteArray(new File(path +"/"+ file_path));
			
			res.setContentType("application/octet-stream");
			res.setContentLength(fileByte.length);
			res.setHeader("Content-Disposition",
					"attachment; fileName=\"" + URLEncoder.encode(file_path, "UTF-8") + "\";");
			res.setHeader("Content-Transfer-Encoding", "binary");
			res.getOutputStream().write(fileByte);
			
			res.getOutputStream().flush();
		    res.getOutputStream().close();
		    			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
