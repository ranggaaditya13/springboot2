package com.rangga.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rangga.models.EmployeeModel;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Integer> {

	@Query(value="select * from employee order by id",nativeQuery = true)
	public List<Map<String, Object>> listEmployee();
	
	@Modifying
	@Query(value="insert into employee(nama,jenis_kelamin,telephone) values(?1,?2,?3)",nativeQuery = true)
	int insert(String nama,String jenis_kelamin,String telephone);
	
	@Modifying
	@Query(value="update employee set nama=?1,jenis_kelamin=?2,telephone=?3 where id = ?4",nativeQuery = true)
	int updateData(String nama,String jenis_kelamin, String telephone,int id);
	
	@Modifying
	@Query(value="delete employee where id = ?1")
	int deleteData(int id);
	
}