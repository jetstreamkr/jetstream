package kr.jetstream.member.dao;

import kr.jetstream.member.dto.MemberDTO;

public interface MemberDAO {
	//�α���
	MemberDTO login(String email, String password);
	//ȸ������
	void insert(MemberDTO dto);
}