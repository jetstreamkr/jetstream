package kr.jetstream.member.dao;

import kr.jetstream.member.dto.MemberDTO;

public interface MemberDAO {
	//로그인
	MemberDTO login(String email, String password);
	//회원가입
	void insert(MemberDTO dto);
}