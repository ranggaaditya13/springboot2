package com.rangga.dao;

import java.util.List;

import com.rangga.entity.PositionEntity;

public interface DaoPosition {
	
	public List<PositionEntity> getList();
	PositionEntity savePosition(PositionEntity position);
	PositionEntity getPositionById(int id);
	PositionEntity updatePosition(PositionEntity position,int id);

}
