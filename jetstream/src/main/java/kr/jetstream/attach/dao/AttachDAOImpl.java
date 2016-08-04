package kr.jetstream.attach.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.jetstream.attach.dto.FileDTO;

@Repository
public class AttachDAOImpl implements AttachDAO {

	@Autowired
	SqlSession sqlsession;
	
	@Override
	public void insert(FileDTO file) {
		sqlsession.insert("jetstream.card.fileupload", file);
	}

	@Override
	public List<FileDTO> list(String card_id) {
		return sqlsession.selectList("jetstream.card.filelist", card_id);
	}

	@Override
	public void delete(String card_id, String file_path) {
		FileDTO dto = new FileDTO(card_id,file_path);
		sqlsession.delete("jetstream.card.filedelete",dto);
	}

}
