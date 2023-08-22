package com.nostramovie.controllers;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nostramovie.models.MovieModel;
import com.nostramovie.repositories.MovieRepository;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class MovieController {
	
	@Autowired
	private MovieRepository mr;
	
	 @GetMapping("/movies")
	  public ResponseEntity<List<MovieModel>> getAllMovieModels(@RequestParam(required = false) String title) {
	    List<MovieModel> movies = new ArrayList<MovieModel>();
	    if (title == null)
	      mr.findAll().forEach(movies::add);
	    else
	      mr.findByTitleContaining(title).forEach(movies::add);
	    if (movies.isEmpty()) {
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(movies, HttpStatus.OK);
	  }
	 
	  @GetMapping("/movies/{id}")
	  public ResponseEntity<MovieModel> getMovieModelById(@PathVariable("id") long id) {
	    MovieModel MovieModel = mr.findById(id)
	        .orElseThrow();
	    return new ResponseEntity<>(MovieModel, HttpStatus.OK);
	  }
	  @PostMapping("/movies/create")
	  public ResponseEntity<MovieModel> createMovieModel(@RequestBody MovieModel MovieModel) {
	    MovieModel _MovieModel = mr.save(new MovieModel(MovieModel.getId(),MovieModel.getTitle(), MovieModel.getDescription(),
	    		MovieModel.getPublisher(),MovieModel.getRating()));
	    return new ResponseEntity<>(_MovieModel, HttpStatus.CREATED);
	  }
	  @PutMapping("/movies/{id}")
	  public ResponseEntity<MovieModel> updateMovieModel(@PathVariable("id") long id, @RequestBody MovieModel MovieModel) {
	    MovieModel _MovieModel = mr.findById(id)
	        .orElseThrow();
	    _MovieModel.setTitle(MovieModel.getTitle());
	    _MovieModel.setDescription(MovieModel.getDescription());
	    _MovieModel.setPublisher(MovieModel.getPublisher());
	    
	    return new ResponseEntity<>(mr.save(_MovieModel), HttpStatus.OK);
	  }
	  @DeleteMapping("/movies/{id}")
	  public ResponseEntity<HttpStatus> deleteMovieModel(@PathVariable("id") long id) {
	    mr.deleteById(id);
	    
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }
	  @DeleteMapping("/movies/delete")
	  public ResponseEntity<HttpStatus> deleteAllMovieModels() {
	    mr.deleteAll();
	    
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }
	  
	  //belum digunakan
	  @GetMapping("/movies/published")
	  public ResponseEntity<List<MovieModel>> findByPublished() {
	    List<MovieModel> MovieModels = mr.findAll();
	    if (MovieModels.isEmpty()) {
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    
	    return new ResponseEntity<>(MovieModels, HttpStatus.OK);
	  }

}
