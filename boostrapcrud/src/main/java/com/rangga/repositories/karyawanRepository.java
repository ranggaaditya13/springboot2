package com.rangga.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rangga.models.karyawanModel;

@Repository
public interface karyawanRepository extends JpaRepository<karyawanModel, Integer> {
	
	Optional<karyawanModel> findById(int id);

}
