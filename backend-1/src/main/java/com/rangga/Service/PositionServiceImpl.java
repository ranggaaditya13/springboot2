package com.rangga.Service;


import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
import org.springframework.transaction.annotation.Transactional;

import com.rangga.DAO.PositionDAO;
import com.rangga.entity.PositionEntity;  

@Service
@Transactional
public class PositionServiceImpl implements PositionService {
	
	@Autowired
	private PositionDAO dao;

	@Override
	public boolean savePosition(PositionEntity position) {
		return dao.savePosition(position);
	}

	@Override
	public List<PositionEntity> getPosition() {
	return dao.getPosition();
	}

	@Override
	public boolean deletePosition(PositionEntity position) {
		return dao.deletePosition(position);
	}

	@Override
	public List<PositionEntity> getPositionById(PositionEntity position) {
		return dao.getPositionById(position);
	}

	@Override
	public boolean updatePosition(PositionEntity position) {
		return dao.updatePosition(position);
	}
	
	

}
