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

	// 대시보드 조회
	@Override
	public List<BoardDTO> dashboard(String member_id) {
		return dao.dashboard(member_id);
	}

	// 보드 생성
	@Override
	public void createBoard(BoardDTO board) {
		dao.createBoard(board);
	}

	// 보드 생성 후 바로 보드로 들어가기 위한 보드번호 따기
	@Override
	public String getBoardId(String member_id) {
		return dao.getBoardId(member_id);
	}

	// 보드 보기
	@Override
	public BoardDTO viewBoard(String board_id) {
		return dao.viewBoard(board_id);
	}
	
	// 내 보드 보기
	@Override
	public BoardDTO viewMyBoard(BoardDTO board) {
		return dao.viewMyBoard(board);
	}

	// 보드 클로즈
	@Override
	public void closeBoard(String board_id) {
		dao.closeBoard(board_id);
	}

	// 보드 리네임
	@Override
	public void renameBoard(BoardDTO board) {
		dao.renameBoard(board);

	}
	// 보드 세팅
		// 보드 멤버 보기
		@Override
		public List<MemberDTO> viewBoardMember(String board_id) {
			return dao.viewBoardMember(board_id);
		}
		
		// 보드 멤버 추가를 위한 멤버 검색
		@Override
		public List<MemberDTO> searchBoardMember(String keyword) {
			return dao.searchBoardMember(keyword);
		}

		// 보드 멤버 추가
		@Override
		public void addBoardMember(BoardDTO board) {
			dao.addBoardMember(board);
		}

		// 보드 멤버 권한 수정, 삭제
		@Override
		public void setBoardMember(BoardDTO board) {
			dao.setBoardMember(board);
		}
}
