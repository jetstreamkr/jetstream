package kr.jetstream.pack.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.jetstream.pack.dto.PackDTO;
@Repository("packdao")
public class PackDAOImpl implements PackDAO{
	@Autowired
	SqlSession sqlsession;

	//리스트 생성
	@Override
	public void createList(PackDTO pack) {
		sqlsession.insert("jetstream.pack.createPack", pack);
		
	}

	//리스트 수정
	@Override
	public void update(PackDTO packInfo) {
		sqlsession.insert("jetstream.pack.updatePack", packInfo);
		
	}

	//리스트 삭제
	@Override
	public void delete(String pack_id) {
		sqlsession.insert("jetstream.pack.deletePack", pack_id);
		
	}

	//리스트 목록
	@Override
	public List<PackDTO> packList(String board_id) {
		return sqlsession.selectList("jetstream.pack.packList", board_id);
	}
}
