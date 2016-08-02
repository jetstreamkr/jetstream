package kr.jetstream.member.service;

import java.util.List;

import kr.jetstream.member.dto.MemberDTO;

public interface MemberService {

	//�α���
	MemberDTO login(String email, String password);
	//ȸ������
	void insert(MemberDTO dto);
	//ȸ�� ������Ʈ
	void update(String member_nm, String password, String photo, String email);
	
	//ȸ�� �˻�	
	public List<String> findMember(String searchData);
}