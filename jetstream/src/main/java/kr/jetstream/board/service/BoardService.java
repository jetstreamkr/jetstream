package kr.jetstream.board.service;

import java.util.List;

import kr.jetstream.board.dto.BoardDTO;

public interface BoardService {

	// 대시보드 조회
	public List<BoardDTO> dashboard(String member_id);
	
	// 보드 생성
	public void createBoard(BoardDTO board);
	
	// 보드 생성 후 바로 보드로 들어가기 위한 보드번호 따기
	public String getBoardId(String member_id);
	
	// 보드 보기
	public BoardDTO viewBoard(String board_id);

	// 보드 세팅
	
	// 보드 삭제
	
	
}
