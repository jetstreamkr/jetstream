package kr.jetstream.board.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import kr.jetstream.board.dto.BoardDTO;
import kr.jetstream.board.dto.BoardRepository;
@Repository
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	BoardRepository repository;
	
	@Override
	public BoardDTO findByID(String key, String value) {
		Criteria criteria = new Criteria(key);
		criteria.is(value);
		Query query = new Query(criteria);
		BoardDTO data = mongoTemplate.findOne(query, BoardDTO.class, "board");
		return data;
	}

	@Override
	public void update(BoardDTO document) {
		Criteria criteria = new Criteria("boardID");
		criteria.is(document.getBoardID());
		Query query = new Query(criteria);
		
		Update update = new Update();
		update.set("boardName", document.getBoardName());
		update.set("boardPermission", document.getBoardPermission());
		update.set("boardStart", document.getBoardStart());
		update.set("boardDue", document.getBoardDue());
		
		mongoTemplate.updateMulti(query, update, "board");
	}

	@Override
	public void insertDocument(BoardDTO doc) {
		mongoTemplate.insert(doc);
		
	}
	
	public List<BoardDTO> findAll(){
		List<BoardDTO> boardList = (List<BoardDTO>) repository.findAll();
		return boardList;
	}

}
