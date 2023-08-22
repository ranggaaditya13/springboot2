package com.rangga.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.rangga.entity.EmployeeEntity;
import com.rangga.entity.PositionEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
	
	@Query(value = "select e.id,e.name,e.birth_date,p.name,e.id_number,e.gender,e.is_deleted,e.position_id from employee e "
			+ "join position p on p.id = e.position_id where e.is_deleted = 0",nativeQuery = true)
	public List<EmployeeEntity> newList();
	
	@Modifying
	@Query(value = "update employee set is_deleted = 1 where id = ?",nativeQuery = true)
	public int updateData(int id);


}
