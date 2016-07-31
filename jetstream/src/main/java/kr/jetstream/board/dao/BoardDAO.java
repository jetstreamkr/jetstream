package kr.jetstream.board.dao;

import java.util.List;

import kr.jetstream.board.dto.BoardDTO;
import kr.jetstream.member.dto.MemberDTO;

public interface BoardDAO {
	// ��ú��� ��ȸ
	public List<BoardDTO> dashboard(String member_id);
	
	// ���� ����
	public void createBoard(BoardDTO board);
	
	// ���� ���� �� �ٷ� ����� ���� ���� �����ȣ ����
	public String getBoardId(String member_id);
	
	// ���� ����
	public BoardDTO viewBoard(String board_id);

	// �� ���� ����
	public BoardDTO viewMyBoard(BoardDTO board);
	
	// ���� ����
	public void setBoard(BoardDTO board);
		
	// ���� ����
	public void closeBoard(String board_id);

	//���� ������
	public void renameBoard(BoardDTO board);
	
	
// ���� ����
	// ���� ��� ����
	public List<MemberDTO> viewBoardMember(String board_id);
	
	// ���� ��� �߰��� ���� ��� �˻�
	public List<MemberDTO> searchBoardMember(String keyword);
	
	// ���� ��� �߰�
	public void addBoardMember(BoardDTO board);
	
	// ���� ��� ���� ����, ����
	public void setBoardMember(BoardDTO board);
	
}
