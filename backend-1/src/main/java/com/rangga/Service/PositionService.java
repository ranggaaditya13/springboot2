package com.rangga.Service;

import java.util.List;

import com.rangga.entity.PositionEntity;

public interface PositionService {
	public boolean savePosition(PositionEntity position);  
    public List<PositionEntity> getPosition();  
    public boolean deletePosition(PositionEntity position);  
    public List<PositionEntity> getPositionById(PositionEntity position);  
    public boolean updatePosition(PositionEntity position);  

}
