package com.rangga.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.rangga.entity.PositionEntity;

public interface PositionRepository extends JpaRepository<PositionEntity, Integer> {
	
	@Query(value = "select * from position where is_deleted = 0",nativeQuery = true)
	public List<PositionEntity> newList();
	
	@Modifying
	@Query(value = "update position set is_deleted = 1 where id = ?",nativeQuery = true)
	public int updateData(int id);


}
