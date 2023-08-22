package com.nostramovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nostramovie.models.FileModel;

@Repository	
public interface FileRepository extends JpaRepository<FileModel, String> {

}
