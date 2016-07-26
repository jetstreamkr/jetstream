package kr.jetstream.member.service;

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
	
	// ·Î±×ÀÎ
	@Override
	public MemberDTO login(String email, String password) {
		return dao.login(email, password);
	}

	@Override
	public void insert(MemberDTO dto) {
		dao.insert(dto);
	}
}
