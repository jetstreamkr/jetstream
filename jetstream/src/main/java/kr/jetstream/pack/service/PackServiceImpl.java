package kr.jetstream.pack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.jetstream.pack.dao.PackDAO;
import kr.jetstream.pack.dto.PackDTO;
@Service
public class PackServiceImpl implements PackService{
	@Autowired
	PackDAO dao;
	
	@Override
	public void createList(PackDTO pack) {
		dao.createList(pack);
		
	}

	@Override
	public void update(PackDTO packInfo) {
		dao.update(packInfo);
		
	}

	@Override
	public void closePack(String pack_id) {
		dao.closePack(pack_id);
		
	}

	@Override
	public List<PackDTO> packList(String board_id) {
		return dao.packList(board_id);
	}

}
