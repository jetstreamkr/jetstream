package kr.jetstream.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.jetstream.member.dao.MemberDAO;
import kr.jetstream.member.dto.MemberDTO;
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	@Qualifier("memberdao")
	MemberDAO dao;
	
	// 로그인
	@Override
	public MemberDTO login(String email, String password) {
		return dao.login(email, password);
	}

	@Override
	public void insert(MemberDTO dto) {
		dao.insert(dto);
	}

	@Override
	public void update(String member_nm, String password, String photo, String email) {
		dao.update(member_nm, password, photo, email);
	}
	
	//회원 검색	
	@Override
	public List<String> findMember(String searchData) {
		return dao.findMember(searchData);
	}

	@Override
	public boolean CheckId(String email) {
		return dao.CheckId(email);
	}

	@Override
	public MemberDTO findPass(String email) {
		return dao.findPass(email);
	}
}
