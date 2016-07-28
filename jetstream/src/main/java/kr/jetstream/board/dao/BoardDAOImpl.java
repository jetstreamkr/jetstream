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

	// ��ú��� ��ȸ
	@Override
	public List<BoardDTO> dashboard(String member_id) {
		return sqlsession.selectList("jetstream.board.dashboard", member_id);
	}

	// ���� ����
	@Override
	public void createBoard(BoardDTO board) {
		sqlsession.insert("jetstream.board.createBoard", board);
	}

	// ���� ���� �� �ٷ� ����� ���� ���� �����ȣ ����
	@Override
	public String getBoardId(String member_id) {
		return sqlsession.selectOne("jetstream.board.getBoardId", member_id);
	}

	// ���� ����
	@Override
	public BoardDTO viewBoard(String board_id) {
		return sqlsession.selectOne("jetstream.board.viewBoard", board_id);
	}

	// ���� ����
	@Override
	public void closeBoard(String board_id) {
		sqlsession.update("jetstream.board.closeBoard", board_id);
	}

	// ���� ������
	@Override
	public void renameBoard(BoardDTO board) {
		sqlsession.update("jetstream.board.renameBoard", board);
	}

}
