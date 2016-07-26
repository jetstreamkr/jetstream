package kr.jetstream.board.dao;

import java.util.List;

import kr.jetstream.board.dto.BoardDTO;

public interface BoardDAO {
//	public BoardDTO findByID(String key, String value);
//	public void update(BoardDTO document);
//	public void insertDocument(BoardDTO doc);
//	public List<BoardDTO> findAll();

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
