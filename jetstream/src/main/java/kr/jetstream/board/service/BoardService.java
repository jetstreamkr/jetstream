package kr.jetstream.board.service;

import java.util.List;

import kr.jetstream.board.dto.BoardDTO;

public interface BoardService {

	// ��ú��� ��ȸ
	public List<BoardDTO> dashboard(String member_id);
	
	// ���� ����
	public void createBoard(BoardDTO board);
	
	// ���� ���� �� �ٷ� ����� ���� ���� �����ȣ ����
	public String getBoardId(String member_id);
	
	// ���� ����
	public BoardDTO viewBoard(String board_id);

	// ���� ����
	
	// ���� ����
	
	
}
