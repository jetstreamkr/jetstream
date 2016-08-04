package kr.jetstream.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.jetstream.board.dao.BoardDAO;
import kr.jetstream.board.dto.BoardDTO;
import kr.jetstream.card.dto.CardDTO;
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
	

	@Override
	public String findBoardfav(String board_id) {
		return dao.findBoardfav(board_id);
	}

	@Override
	public void setBoardfavToY(String board_id) {
		dao.setBoardfavToY(board_id);
		
	}

	@Override
	public void setBoardfavToN(String board_id) {
		dao.setBoardfavToN(board_id);
	}

	@Override
	public List<BoardDTO> favdashboard(String member_id) {
		return dao.favdashboard(member_id);
	}
	
	
// 보드 세팅
	// 보드 정보 수정
	@Override
	public void setBoard(BoardDTO board) {
		dao.setBoard(board);
	}

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

	   //service for calendar
    //뿌려질 카드네임, 기간 받아오기
	 @Override
    public List<CardDTO> selectCard(String board_id){
       return dao.selectCard(board_id);
    }

    //캘린더에 디폴트할 오늘 날짜 받아오기
    @Override
    public String selectToday() {
       return dao.selectToday();
    }
    
}
