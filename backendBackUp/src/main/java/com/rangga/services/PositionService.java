package com.rangga.services;

import java.util.List;

import com.rangga.entity.PositionEntity;

public interface PositionService {
	
	PositionEntity savePosition(PositionEntity position);
//	List<PositionEntity> listPosition();
	PositionEntity getPositionById(int id);
	PositionEntity updatePosition(PositionEntity position, int id);
	List<PositionEntity> FindAllQ();
	PositionEntity deletePosition(int id, PositionEntity position);

}
