package kr.jetstream.attach.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import kr.jetstream.attach.dto.FileDTO;
import kr.jetstream.attach.dto.PhotoDTO;
import kr.jetstream.attach.service.AttachService;

@Controller
public class AttachCreateController {
   
   @Autowired
   AttachService service;
   
   @RequestMapping(value="/attach.do", method=RequestMethod.POST)
   public ModelAndView fileUpload(HttpSession session, PhotoDTO dto, 
         @RequestParam("file") MultipartFile file, HttpServletRequest req,
         String card_id, String board_id){
      
      ModelAndView mav = new ModelAndView();
      System.out.println("ehlsl");
      String file_nm = file.getOriginalFilename();

      try {
         String path = WebUtils.getRealPath(req.getSession().getServletContext(),
               "/resources/files");
         long time = System.currentTimeMillis(); 
         File f = new File(path +"/"+time + file_nm);
         file.transferTo(f);
         FileDTO filedto= new FileDTO(board_id, card_id, time+ file_nm,file_nm);
         service.insert(filedto);
         
      } catch (IllegalStateException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
      mav.setViewName("redirect:/board/board_list.do?board_id="+board_id);
      return mav;
   }
}