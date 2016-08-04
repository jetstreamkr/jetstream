package kr.jetstream.member.dao;

import java.util.List;

import kr.jetstream.member.dto.MemberDTO;

public interface MemberDAO {
	// 로그인
	MemberDTO login(String email, String password);

	// 회원가입
	void insert(MemberDTO dto);

	// 회원 업데이트
	void update(String member_nm, String password, String photo, String email);

	public List<String> findMember(String searchData);

	// 이메일 중복체크
	boolean CheckId(String email);
	
	//비밀번호 찾기 
	MemberDTO findPass(String email);

}