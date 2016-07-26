package kr.jetstream.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.jetstream.board.dao.BoardDAO;
import kr.jetstream.board.dto.BoardDTO;
@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDAO dao;
		
	@Override
	public BoardDTO findByID(String key, String value) {
		return dao.findByID(key, value);
	}

	@Override
	public void update(BoardDTO document) {
		dao.update(document);
	}

	@Override
	public void insertDocument(BoardDTO doc) {
		dao.insertDocument(doc);
	}

	@Override
	public List<BoardDTO> findAll() {
		return dao.findAll();
	}

}
