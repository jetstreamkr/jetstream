package kr.jetstream.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.jetstream.admin.dao.AdminDAO;
import kr.jetstream.admin.dto.ChartDTO;
import kr.jetstream.board.dto.BoardDTO;
import kr.jetstream.member.dto.MemberDTO;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminDAO dao;
	
	//멤버 조회
	@Override
	public List<MemberDTO> readMember() {
		// TODO Auto-generated method stub
		return dao.readMember();
	}

	//보드 조회
	@Override
	public List<BoardDTO> readBoard() {
		// TODO Auto-generated method stub
		return dao.readBoard();
	}

	@Override
	public List<ChartDTO> adminChart() {
		// TODO Auto-generated method stub
		return dao.adminChart();
	}
	
	@Override
	public MemberDTO detaileMember(String memberId) {
		return dao.detaileMember(memberId);
	}

	@Override
	public void updateMember(MemberDTO memberInfo) {
		dao.updateMember(memberInfo);
	}

}
