package kr.jetstream.admin.dao;

import java.util.List;

import kr.jetstream.admin.dto.ChartDTO;
import kr.jetstream.board.dto.BoardDTO;
import kr.jetstream.member.dto.MemberDTO;

public interface AdminDAO {

	// ¸â¹ö Á¶È¸
	public List<MemberDTO> readMember();

	public List<BoardDTO> readBoard();

	public List<ChartDTO> adminChart();

	// ¸â¹ö
	MemberDTO detaileMember(String memberId);

	// ¸â¹ö ¼öÁ¤ÇÏ±â
	public void updateMember(MemberDTO memberInfo);
}
