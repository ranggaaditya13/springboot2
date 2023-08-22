package com.nostramovie.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nostramovie.models.CommentModel;

public interface CommentRepository extends JpaRepository<CommentModel, Long> {
	
	 List<CommentModel> findByMovieId(Long postId);
	  
	  @Transactional
	  void deleteByMovieId(long movieid);

}
