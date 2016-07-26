package kr.jetstream.board.dao;

import java.util.List;

import kr.jetstream.board.dto.BoardDTO;

public interface BoardDAO {
	public BoardDTO findByID(String key, String value);
	public void update(BoardDTO document);
	public void insertDocument(BoardDTO doc);
	public List<BoardDTO> findAll();

}
