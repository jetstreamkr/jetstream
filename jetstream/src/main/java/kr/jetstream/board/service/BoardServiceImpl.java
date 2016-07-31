package kr.jetstream.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.jetstream.board.dao.BoardDAO;
import kr.jetstream.board.dto.BoardDTO;
import kr.jetstream.member.dto.MemberDTO;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDAO dao;

	// ��ú��� ��ȸ
	@Override
	public List<BoardDTO> dashboard(String member_id) {
		return dao.dashboard(member_id);
	}

	// ���� ����
	@Override
	public void createBoard(BoardDTO board) {
		dao.createBoard(board);
	}

	// ���� ���� �� �ٷ� ����� ���� ���� �����ȣ ����
	@Override
	public String getBoardId(String member_id) {
		return dao.getBoardId(member_id);
	}

	// ���� ����
	@Override
	public BoardDTO viewBoard(String board_id) {
		return dao.viewBoard(board_id);
	}
	
	// �� ���� ����
	@Override
	public BoardDTO viewMyBoard(BoardDTO board) {
		return dao.viewMyBoard(board);
	}

	// ���� Ŭ����
	@Override
	public void closeBoard(String board_id) {
		dao.closeBoard(board_id);
	}

	// ���� ������
	@Override
	public void renameBoard(BoardDTO board) {
		dao.renameBoard(board);

	}
	// ���� ����
		// ���� ��� ����
		@Override
		public List<MemberDTO> viewBoardMember(String board_id) {
			return dao.viewBoardMember(board_id);
		}
		
		// ���� ��� �߰��� ���� ��� �˻�
		@Override
		public List<MemberDTO> searchBoardMember(String keyword) {
			return dao.searchBoardMember(keyword);
		}

		// ���� ��� �߰�
		@Override
		public void addBoardMember(BoardDTO board) {
			dao.addBoardMember(board);
		}

		// ���� ��� ���� ����, ����
		@Override
		public void setBoardMember(BoardDTO board) {
			dao.setBoardMember(board);
		}
}
