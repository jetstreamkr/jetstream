package kr.jetstream.board.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.jetstream.board.dto.BoardDTO;
import kr.jetstream.member.dto.MemberDTO;

@Repository("boarddao")
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	SqlSession sqlsession;

	// 대시보드 조회
	@Override
	public List<BoardDTO> dashboard(String member_id) {
		return sqlsession.selectList("jetstream.board.dashboard", member_id);
	}

	// 보드 생성
	@Override
	public void createBoard(BoardDTO board) {
		sqlsession.insert("jetstream.board.createBoard", board);
	}

	// 보드 생성 후 바로 보드로 들어가기 위한 보드번호 따기
	@Override
	public String getBoardId(String member_id) {
		return sqlsession.selectOne("jetstream.board.getBoardId", member_id);
	}

	// 보드 보기
	@Override
	public BoardDTO viewBoard(String board_id) {
		return sqlsession.selectOne("jetstream.board.viewBoard", board_id);
	}
	
	// 내 보드 보기
	@Override
	public BoardDTO viewMyBoard(BoardDTO board) {
		return sqlsession.selectOne("jetstream.board.viewMyBoard", board);
	}

	// 보드 삭제
	@Override
	public void closeBoard(String board_id) {
		sqlsession.update("jetstream.board.closeBoard", board_id);
	}

	// 보드 리네임
	@Override
	public void renameBoard(BoardDTO board) {
		sqlsession.update("jetstream.board.renameBoard", board);
	}
	
	@Override
	public String findBoardfav(String board_id) {
		return sqlsession.selectOne("jetstream.board.findBoardfav", board_id);
	}

	@Override
	public void setBoardfavToY(String board_id) {
		sqlsession.update("jetstream.board.setBoardfavToY", board_id);
	}

	@Override
	public void setBoardfavToN(String board_id) {
		sqlsession.update("jetstream.board.setBoardfavToN", board_id);
	}

	@Override
	public List<BoardDTO> favdashboard(String member_id) {
		return sqlsession.selectList("jetstream.board.favdashboard", member_id);
	}
	



// 보드 세팅
	
	// 보드 정보 수
	@Override
	public void setBoard(BoardDTO board) {
		sqlsession.update("jetstream.board.setBoard", board);
		
	}
	
	// 보드 멤버 보기
	@Override
	public List<MemberDTO> viewBoardMember(String board_id) {
		return sqlsession.selectList("jetstream.board.viewBoardMember", board_id);
	}
	
	// 보드 멤버 추가를 위한 멤버 검색
	@Override
	public List<MemberDTO> searchBoardMember(String keyword) {
		return sqlsession.selectList("jetstream.board.searchBoardMember", keyword);
	}

	// 보드 멤버 추가
	@Override
	public void addBoardMember(BoardDTO board) {
		sqlsession.insert("jetstream.board.addBoardMember", board);
	}

	// 보드 멤버 권한 수정, 삭제
	@Override
	public void setBoardMember(BoardDTO board) {
		sqlsession.insert("jetstream.board.setBoardMember", board);
	}



}
