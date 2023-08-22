package com.nostramovie.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nostramovie.models.CommentModel;
import com.nostramovie.repositories.CommentRepository;
import com.nostramovie.repositories.MovieRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class CommentController {
	
	@Autowired
	private MovieRepository mr;
	@Autowired
	private CommentRepository commentRepository;
	  @GetMapping("/tutorials/{tutorialId}/comments")
	  public ResponseEntity<List<CommentModel>> getAllCommentsByTutorialId(@PathVariable(value = "movieid") Long movieid) {
	    if (!mr.existsById(movieid)) {
	     System.out.println("Tidak ada");
	    }
	    List<CommentModel> comments = commentRepository.findByMovieId(movieid);
	    return new ResponseEntity<>(comments, HttpStatus.OK);
	  }
	  @GetMapping("/comments/{id}")
	  public ResponseEntity<CommentModel> getCommentsByTutorialId(@PathVariable(value = "id") Long id) {
	    CommentModel comment = commentRepository.findById(id)
	        .orElseThrow();
	    return new ResponseEntity<>(comment, HttpStatus.OK);
	  }
	  @PostMapping("/tutorials/{tutorialId}/comments")
	  public ResponseEntity<CommentModel> createComment(@PathVariable(value = "movieid") Long movieid,
	      @RequestBody CommentModel commentRequest) {
	    CommentModel comment = mr.findById(movieid).map(movie -> {
	      commentRequest.setMovie(movie);
	      return commentRepository.save(commentRequest);
	    }).orElseThrow();
	    return new ResponseEntity<>(comment, HttpStatus.CREATED);
	  }
	  @PutMapping("/comments/{id}")
	  public ResponseEntity<CommentModel> updateComment(@PathVariable("id") long id, @RequestBody CommentModel commentRequest) {
	    CommentModel comment = commentRepository.findById(id)
	        .orElseThrow();
	    comment.setContent(commentRequest.getContent());
	    return new ResponseEntity<>(commentRepository.save(comment), HttpStatus.OK);
	  }
	  @DeleteMapping("/comments/{id}")
	  public ResponseEntity<HttpStatus> deleteComment(@PathVariable("id") long id) {
	    commentRepository.deleteById(id);
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }
	  
	  @DeleteMapping("/movies/{movieid}/comments")
	  public ResponseEntity<List<CommentModel>> deleteAllCommentsOfTutorial(@PathVariable(value = "movieid") Long movieid) {
	    if (!mr.existsById(movieid)) {
	      System.out.println("tidak ada");
	    }
	    commentRepository.deleteByMovieId(movieid);
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }

}
