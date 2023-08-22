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

import com.nostramovie.exceptions.ResourceNotFoundException;
import com.nostramovie.models.CommentModel;
import com.nostramovie.repositories.CommentRepository;
import com.nostramovie.repositories.FileRepository;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class CommentController {
	
	@Autowired
	private FileRepository mr;
	@Autowired
	private CommentRepository commentRepository;
	  @GetMapping("/movies/{fileid}/comments")
	  public ResponseEntity<List<CommentModel>> getAllCommentsByTutorialId(@PathVariable(value = "files_id") String fileid) {
		  if (!mr.existsById(fileid)) {
	     System.out.println("Tidak ada");
	    }
	    List<CommentModel> comments = commentRepository.findByMovieId(fileid);
	    return new ResponseEntity<>(comments, HttpStatus.OK);
	  }
	  @GetMapping("/comments/{id}")
	  public ResponseEntity<CommentModel> getCommentsByTutorialId(@PathVariable(value = "id") String id) {
	    CommentModel comment = commentRepository.findById(id)
	    		 .orElseThrow(() -> new ResourceNotFoundException("Not found Movie with id = " + id));
	    return new ResponseEntity<>(comment, HttpStatus.OK);
	  }
	  @PostMapping("/movies/{fileid}/comments")
	  public ResponseEntity<CommentModel> createComment(@PathVariable(value = "files_id") String fileid,
	      @RequestBody CommentModel commentRequest) {
	    CommentModel comment = mr.findById(fileid).map(movie -> {
	      commentRequest.setMovie(movie);
	      return commentRepository.save(commentRequest);
	    }) .orElseThrow(() -> new ResourceNotFoundException("Not found Movie with id = " + fileid));
	    return new ResponseEntity<>(comment, HttpStatus.CREATED);
	  }
	  @PutMapping("/comments/{id}")
	  public ResponseEntity<CommentModel> updateComment(@PathVariable("id") String id, @RequestBody CommentModel commentRequest) {
	    CommentModel comment = commentRepository.findById(id)
	    		 .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));
	    comment.setContent(commentRequest.getContent());
	    return new ResponseEntity<>(commentRepository.save(comment), HttpStatus.OK);
	  }
	  @DeleteMapping("/comments/{id}")
	  public ResponseEntity<HttpStatus> deleteComment(@PathVariable("id") String id) {
	    commentRepository.deleteById(id);
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }
	  
	  @DeleteMapping("/movies/{fileid}/comments")
	  public ResponseEntity<List<CommentModel>> deleteAllCommentsOfTutorial(@PathVariable(value = "files_id") String fileid) {
	    if (!mr.existsById(fileid)) {
	      System.out.println("tidak ada");
	    }
	    commentRepository.deleteByMovieId(fileid);
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }

}