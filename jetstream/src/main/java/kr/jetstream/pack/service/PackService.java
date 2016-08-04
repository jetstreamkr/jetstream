package kr.jetstream.pack.service;

import java.util.List;

import kr.jetstream.pack.dto.PackDTO;

public interface PackService {
	
		//����Ʈ ����
		public void createList(PackDTO pack);
		
		//����Ʈ ����
		public void update(PackDTO packInfo);
		
		//����Ʈ ����
		public void closePack(String pack_id);
		
		//����Ʈ ���
		public List<PackDTO> packList(String board_id);
}
