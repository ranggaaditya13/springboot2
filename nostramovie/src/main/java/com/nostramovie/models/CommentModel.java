package com.nostramovie.models;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="comments")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="comment_generator")
	private long id;
	
	@Lob
	private String content;
	
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	 @JoinColumn(name = "movie_id", nullable = false)
	 @OnDelete(action = OnDeleteAction.CASCADE)
	 @JsonIgnore
	 private MovieModel movie;

}
