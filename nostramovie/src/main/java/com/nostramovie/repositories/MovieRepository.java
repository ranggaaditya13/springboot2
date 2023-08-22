package com.nostramovie.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nostramovie.models.MovieModel;

public interface MovieRepository extends JpaRepository<MovieModel, Long> {
	
	List<MovieModel> findByTitleContaining(String title);

}
