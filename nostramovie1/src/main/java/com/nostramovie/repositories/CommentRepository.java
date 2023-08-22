package com.nostramovie.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nostramovie.models.CommentModel;

public interface CommentRepository extends JpaRepository<CommentModel, String> {
	
	 List<CommentModel> findByMovieId(String postId);
	  
	  @Transactional
	  void deleteByMovieId(String fileid);

}
