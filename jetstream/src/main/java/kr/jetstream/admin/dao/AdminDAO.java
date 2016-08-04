package kr.jetstream.admin.dao;

import java.util.List;

import kr.jetstream.admin.dto.ChartDTO;
import kr.jetstream.board.dto.BoardDTO;
import kr.jetstream.member.dto.MemberDTO;

public interface AdminDAO {

	// ��� ��ȸ
	public List<MemberDTO> readMember();

	public List<BoardDTO> readBoard();

	public List<ChartDTO> adminChart();

	// ���
	MemberDTO detaileMember(String memberId);

	// ��� �����ϱ�
	public void updateMember(MemberDTO memberInfo);
}
