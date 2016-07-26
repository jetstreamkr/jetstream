package kr.jetstream.member.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.jetstream.member.dto.MemberDTO;

@Repository("memberdao")
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	SqlSession sqlsession;

	// ·Î±×ÀÎ
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
}
