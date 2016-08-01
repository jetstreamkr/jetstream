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

	//����Ʈ ����
	@Override
	public void createList(PackDTO pack) {
		sqlsession.insert("jetstream.pack.createPack", pack);
		
	}

	//����Ʈ ����
	@Override
	public void update(PackDTO packInfo) {
		sqlsession.insert("jetstream.pack.updatePack", packInfo);
		
	}

	//����Ʈ ����
	@Override
	public void delete(String pack_id) {
		sqlsession.insert("jetstream.pack.deletePack", pack_id);
		
	}

	//����Ʈ ���
	@Override
	public List<PackDTO> packList(String board_id) {
		return sqlsession.selectList("jetstream.pack.packList", board_id);
	}
}
