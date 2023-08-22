package com.rangga.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rangga.entity.PositionEntity;
import com.rangga.exception.ResourceNotFoundException;
import com.rangga.repositories.PositionRepository;

@Service
public class PositionServiceImpl implements PositionService {
	
	private PositionRepository repo;

	public PositionServiceImpl(PositionRepository repo) {
		super();
		this.repo = repo;
	}



	@Override
	public PositionEntity savePosition(PositionEntity position) {
		return repo.save(position);
	}

//	@Override
//	public List<PositionEntity> listPosition() {
//		return repo.findAll();
//	}

	@Override
	public PositionEntity getPositionById(int id) {
		return repo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("position", "id", id));
	}

	@Override
	public PositionEntity updatePosition(PositionEntity position, int id) {
		PositionEntity havePosition = repo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("position", "id", id));
		havePosition.setCode(position.getCode());
		havePosition.setName(position.getName());
		havePosition.setIsDeleted(0);
		repo.save(havePosition);
		return havePosition;
	}

	@Override
	public List<PositionEntity> FindAllQ() {
		return repo.newList();
	}



	@Override
	public PositionEntity deletePosition(int id, PositionEntity position) {
		PositionEntity havePosition = repo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("position", "id", id));	
		havePosition.setIsDeleted(1);
		repo.save(havePosition);
		return havePosition;
	}









	

}
