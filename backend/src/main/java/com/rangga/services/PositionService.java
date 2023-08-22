package com.rangga.services;

import java.util.List;

import com.rangga.entity.PositionEntity;

public interface PositionService {
	public List<PositionEntity> getList();
	PositionEntity savePosition(PositionEntity position);
	PositionEntity getPositionById(int id);
	PositionEntity updatePosition(PositionEntity position, int id);
	
	
	

}
