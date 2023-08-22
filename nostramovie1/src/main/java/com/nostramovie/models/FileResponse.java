package com.nostramovie.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FileResponse {
	
	private String id;
	private String name;
	private Long size;
	private String url;
	private String contentType;
	
	private String movieName;
	private String description;
	private double rating;
	

}
