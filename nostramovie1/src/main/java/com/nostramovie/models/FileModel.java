package com.nostramovie.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="FILES")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileModel {
	
	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name = "uuid",strategy = "uuid2")
	private String id;

	
	private String foto_name;
	private String contentType;
	
	private Long size;
	
	private String movieName;
	private String description;
	private double rating;
	
	@Lob
	private byte[] data;
	

}
