package kr.jetstream.member.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.jetstream.member.dto.MemberDTO;

@Repository("memberdao")
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	SqlSession sqlsession;

	// 로그인
	@Override
	public MemberDTO login(String email, String password) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("email", email);
		map.put("password", password);
		return sqlsession.selectOne("jetstream.member.login", map);
	}

	@Override
	public void insert(MemberDTO dto) {
		sqlsession.insert("jetstream.member.insert", dto);
	}
	
	@Override
	public void update(String member_nm, String password, String photo, String email) {
		MemberDTO dto = new MemberDTO(member_nm, password, photo, email);
		sqlsession.update("jetstream.member.update", dto);
	}
	
	@Override
	public List<String> findMember(String searchData) {
		return sqlsession.selectList("jetstream.member.findMember", searchData);
	}
	
	//중복체크 
	@Override
	public boolean CheckId(String email) {
		boolean result = false;
		
		MemberDTO dto= sqlsession.selectOne("jetstream.member.checkId",email);
		if(dto==null){
			result = true;
			System.out.println("데이터 없어요 0");
		}else{
			result = false;
			System.out.println("데이터 있어요 1");
		}
		return result;
	}

	@Override
	public MemberDTO findPass(String email) {
		return sqlsession.selectOne("jetstream.member.findPass", email);
	}


}

