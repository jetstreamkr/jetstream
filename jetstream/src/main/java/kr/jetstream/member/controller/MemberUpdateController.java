package kr.jetstream.member.controller;

import java.io.File;
import java.io.FileOutputStream;
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

import kr.jetstream.attach.dto.PhotoDTO;
import kr.jetstream.member.dto.MemberDTO;
import kr.jetstream.member.service.MemberService;

@Controller
public class MemberUpdateController {

	@Autowired
	MemberService service;

	//회원 수정 페이지로 이동
	@RequestMapping(value = "memberupdate.do", method = RequestMethod.GET)
	public String showpage() {
		return "member/update";
	}

	//회원정보 업데이트
	@RequestMapping(value = "memberupdate.do", method = RequestMethod.POST)
	public ModelAndView fileUpload(HttpSession session, PhotoDTO photo, 
			@RequestParam("file") MultipartFile file, HttpServletRequest req, String member_nm, String prevpass,String pass) {
		
		ModelAndView mav = new ModelAndView();
		MemberDTO dto = (MemberDTO) session.getAttribute("member");
		String filename = file.getOriginalFilename();
		
		if(!dto.getPassword().equals(prevpass)){
			mav.setViewName("error/update");
			return mav;
		}
		
		//image 변경 할 때
		if(!filename.equals("") || filename != null){
			FileOutputStream fos = null;
			long time = System.currentTimeMillis(); 
			filename = time + file.getOriginalFilename();

			try {
				String path = WebUtils.getRealPath(req.getSession().getServletContext(),
						"/resources/images");
				File f = new File(path +"/"+ filename);
				file.transferTo(f);
				dto.setPhoto(filename);
				
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//이름 변경되었을 때
		if(!dto.getMember_nm().equals(member_nm)){
			dto.setMember_nm(member_nm);
			String member_init = member_nm.substring(0, 1);
			dto.setMember_init(member_init);
		}
		//패스워드 변경되었을 때
		if(!dto.getPassword().equals(pass)){
			dto.setPassword(pass);
		}

		service.update(dto.getMember_nm(), dto.getPassword(), dto.getPhoto(), dto.getEmail());
		session.removeAttribute("member");
		session.setAttribute("member", dto);
		mav.setViewName("redirect:dashboard.do");
		return mav;
	}

}
