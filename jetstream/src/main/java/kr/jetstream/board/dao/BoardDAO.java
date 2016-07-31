package kr.jetstream.board.dao;

import java.util.List;

import kr.jetstream.board.dto.BoardDTO;
import kr.jetstream.member.dto.MemberDTO;

public interface BoardDAO {
	// 대시보드 조회
	public List<BoardDTO> dashboard(String member_id);
	
	// 보드 생성
	public void createBoard(BoardDTO board);
	
	// 보드 생성 후 바로 보드로 들어가기 위한 보드번호 따기
	public String getBoardId(String member_id);
	
	// 보드 보기
	public BoardDTO viewBoard(String board_id);

	// 내 보드 보기
	public BoardDTO viewMyBoard(BoardDTO board);
	
	// 보드 세팅
	public void setBoard(BoardDTO board);
		
	// 보드 삭제
	public void closeBoard(String board_id);

	//보드 리네임
	public void renameBoard(BoardDTO board);
	
	
// 보드 세팅
	// 보드 멤버 보기
	public List<MemberDTO> viewBoardMember(String board_id);
	
	// 보드 멤버 추가를 위한 멤버 검색
	public List<MemberDTO> searchBoardMember(String keyword);
	
	// 보드 멤버 추가
	public void addBoardMember(BoardDTO board);
	
	// 보드 멤버 권한 수정, 삭제
	public void setBoardMember(BoardDTO board);
	
}
