package kr.jetstream.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.jetstream.board.dto.BoardDTO;

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

}
