package com.nostramovie.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Movie")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_generator")
	private long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="publisher")
	private String publisher;
	
	@Column(name="description")
	private String description;
	
	@Column(name="rating")
	private double rating;
	
	

}
