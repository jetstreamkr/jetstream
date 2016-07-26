package kr.jetstream.board.dto;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface BoardRepository extends PagingAndSortingRepository<BoardDTO, String>{

}
