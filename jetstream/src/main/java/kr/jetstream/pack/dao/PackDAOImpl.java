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

	//����Ʈ Ŭ����
	@Override
	public void closePack(String pack_id) {
		sqlsession.insert("jetstream.pack.closePack", pack_id);
		sqlsession.insert("jetstream.pack.closePack_Card", pack_id);
		
		/*List<String> list = sqlsession.selectList("jetstream.pack.closePack_CardList", pack_id);
		for(int i=0 ; i<list.size() ; i++){
			sqlsession.insert("jetstream.card.closeCardComment",list.get(i));
		}
		System.out.println(list);*/
	}

	//����Ʈ ���
	@Override
	public List<PackDTO> packList(String board_id) {
		return sqlsession.selectList("jetstream.pack.packList", board_id);
	}
}
