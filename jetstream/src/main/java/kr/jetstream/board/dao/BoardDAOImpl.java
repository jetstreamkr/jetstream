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
	
	// �� ���� ����
	@Override
	public BoardDTO viewMyBoard(BoardDTO board) {
		return sqlsession.selectOne("jetstream.board.viewMyBoard", board);
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
	



// ���� ����
	
	// ���� ���� ��
	@Override
	public void setBoard(BoardDTO board) {
		sqlsession.update("jetstream.board.setBoard", board);
		
	}
	
	// ���� ��� ����
	@Override
	public List<MemberDTO> viewBoardMember(String board_id) {
		return sqlsession.selectList("jetstream.board.viewBoardMember", board_id);
	}
	
	// ���� ��� �߰��� ���� ��� �˻�
	@Override
	public List<MemberDTO> searchBoardMember(String keyword) {
		return sqlsession.selectList("jetstream.board.searchBoardMember", keyword);
	}

	// ���� ��� �߰�
	@Override
	public void addBoardMember(BoardDTO board) {
		sqlsession.insert("jetstream.board.addBoardMember", board);
	}

	// ���� ��� ���� ����, ����
	@Override
	public void setBoardMember(BoardDTO board) {
		sqlsession.insert("jetstream.board.setBoardMember", board);
	}



}
