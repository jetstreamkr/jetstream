package kr.jetstream.board.service;

import java.util.List;

import kr.jetstream.board.dto.BoardDTO;
import kr.jetstream.member.dto.MemberDTO;

public interface BoardService {

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

	// ���� Ŭ����
	public void closeBoard(String board_id);

	// ���� ������
	public void renameBoard(BoardDTO board);

	// �������ã�� ���� ��ȸ
	public String findBoardfav(String board_id);

	public void setBoardfavToY(String board_id);
	
	public void setBoardfavToN(String board_id);

	public List<BoardDTO> favdashboard(String member_id);

	
// ���� ����
	// ���� ���� ����
	public void setBoard(BoardDTO board);
	
	// ���� ��� ����
	public List<MemberDTO> viewBoardMember(String board_id);
	
	// ���� ��� �߰��� ���� ��� �˻�
	public List<MemberDTO> searchBoardMember(String keyword);
	
	// ���� ��� �߰�
	public void addBoardMember(BoardDTO board);
	
	// ���� ��� ���� ����, ����
	public void setBoardMember(BoardDTO board);
		
	
}
