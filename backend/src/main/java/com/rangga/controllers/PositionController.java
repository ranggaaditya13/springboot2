package com.rangga.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rangga.entity.PositionEntity;
import com.rangga.services.PositionService;

@RestController
@CrossOrigin(origins="http://localhost:8080")  
public class PositionController {
	
	private PositionService service;

	public PositionController(PositionService service) {
		super();
		this.service = service;
	}
	
	 @PostMapping("post")  
	    public PositionEntity savePosition(@RequestBody PositionEntity position) {  
	         return service.savePosition(position);  
	          
	    }  
	
	@GetMapping("/all")
	public List<PositionEntity> getList(){
		return service.getList();
	}
	
	 @GetMapping("/{id}")  
	    public PositionEntity getPositionById(@PathVariable("id") int id,PositionEntity position) {  
	         position.setId(id);  
	         return service.getPositionById(id);  
	 }
	          
	 @PostMapping("/update/{id}")  
	    public PositionEntity updatePosition(@RequestBody PositionEntity position,@PathVariable("id") int id) {  
	        position.setId(id);  
	        return service.updatePosition(position,id);  
	    }  
}
