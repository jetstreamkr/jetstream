package kr.jetstream.member.service;

import kr.jetstream.member.dto.MemberDTO;

public interface MemberService {

	//�α���
	MemberDTO login(String email, String password);
	//ȸ������
	void insert(MemberDTO dto);
}