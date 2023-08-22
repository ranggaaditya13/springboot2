package com.rangga.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.Query;
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

	@Override
	public List<PositionEntity> getList() {
		return repo.findAll();
	}

	@Override
	public PositionEntity getPositionById(int id) {
		Optional<PositionEntity> position = repo.findById(id);
		if(position.isPresent()) {
			return position.get();
		}else {
			throw new ResourceNotFoundException("position", "id", id);
		}
	
	}

	@Override
	public PositionEntity updatePosition(PositionEntity position, int id) {
		PositionEntity havePosition = repo.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("position", "id", id));
		
		havePosition.setCode(position.getCode());
		havePosition.setName(position.getName());
		havePosition.setIsDeleted(0);
		repo.save(havePosition);
		
		return havePosition;
	}



}
