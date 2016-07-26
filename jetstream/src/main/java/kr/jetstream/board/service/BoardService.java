package kr.jetstream.board.service;

import java.util.List;

import kr.jetstream.board.dto.BoardDTO;

public interface BoardService {
	public BoardDTO findByID(String key, String value);
	public void update(BoardDTO document);
	public void insertDocument(BoardDTO doc);
	public List<BoardDTO> findAll();
}
