package com.rangga.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rangga.models.KaryawanModel;

@Repository
public interface KaryawanRepository extends JpaRepository<KaryawanModel, Integer> {
	
	@Query(value ="select id,nama,gender,email,alamat,no_hp from karyawan",nativeQuery = true)
	public List<KaryawanModel> allData();
	

}
