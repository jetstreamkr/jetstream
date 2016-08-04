package kr.jetstream.pack.service;

import java.util.List;

import kr.jetstream.pack.dto.PackDTO;

public interface PackService {
	
		//리스트 생성
		public void createList(PackDTO pack);
		
		//리스트 수정
		public void update(PackDTO packInfo);
		
		//리스트 삭제
		public void closePack(String pack_id);
		
		//리스트 목록
		public List<PackDTO> packList(String board_id);
}
