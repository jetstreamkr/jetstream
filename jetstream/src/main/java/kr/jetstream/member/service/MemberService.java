package kr.jetstream.member.service;

import kr.jetstream.member.dto.MemberDTO;

public interface MemberService {

	//로그인
	MemberDTO login(String email, String password);
	//회원가입
	void insert(MemberDTO dto);
	//회원 업데이트
	void update(String member_nm, String password, String photo, String email);
	//idcheck
	int idcheck(String email);
	
}