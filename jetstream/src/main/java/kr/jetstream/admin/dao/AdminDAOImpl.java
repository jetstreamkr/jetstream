package kr.jetstream.admin.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.jetstream.admin.dto.ChartDTO;
import kr.jetstream.board.dto.BoardDTO;
import kr.jetstream.member.dto.MemberDTO;

@Repository("admindao")
public class AdminDAOImpl implements AdminDAO {
	@Autowired
	SqlSession sqlsession;
	
	@Override
	public List<MemberDTO> readMember() {
		// TODO Auto-generated method stub
		return sqlsession.selectList("jetstream.admin.readMember");
	}

	//보드 조회
	@Override
	public List<BoardDTO> readBoard() {
		// TODO Auto-generated method stub
		return sqlsession.selectList("jetstream.admin.readBoard");
	}

	@Override
	public List<ChartDTO> adminChart() {
		List<ChartDTO> chartdata = new ArrayList<ChartDTO>();
		ArrayList<String> datelist = chartDate();
		for(int i=0;i<datelist.size();i++){
			String chart_day = datelist.get(i);
			int member_cn = sqlsession.selectOne("jetstream.admin.dateMember",chart_day);
			int board_cn = sqlsession.selectOne("jetstream.admin.dateBoard",chart_day);
			ChartDTO dto = new ChartDTO();
			dto.setChart_day(chart_day);
			dto.setMember_cn(member_cn);
			dto.setBoard_cn(board_cn);
			chartdata.add(dto);
		}
		return chartdata;
	}
	
	public ArrayList<String> chartDate(){
		ArrayList<String> datelist = new ArrayList<String>();
/*		datelist.add("0721");
		datelist.add("0722");
		datelist.add("0723");
		datelist.add("0724");
		datelist.add("0725");
		datelist.add("0726");
		datelist.add("0727");
		datelist.add("0728");
		datelist.add("0729");
		datelist.add("0730");
		datelist.add("0731");*/
		datelist.add("0801");
		datelist.add("0802");
		datelist.add("0803");
		datelist.add("0804");
		datelist.add("0805");
		datelist.add("0806");
		datelist.add("0807");
		datelist.add("0808");
		datelist.add("0809");
		datelist.add("0810");
		
		return datelist;
	}
	@Override
	public MemberDTO detaileMember(String memberId) {
		
		return sqlsession.selectOne("jetstream.admin.detailMember", memberId);
	}

	@Override
	public void updateMember(MemberDTO memberInfo) {
		sqlsession.insert("jetstream.admin.updateMember", memberInfo);
		
	}
	
}
