package com.rangga.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rangga.entity.PositionEntity;
import com.rangga.services.PositionService;

@RestController
public class PositionController {
	
	private PositionService service;

	public PositionController(PositionService service) {
		super();
		this.service = service;
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<PositionEntity> savePosition(@RequestBody PositionEntity position){
		return new ResponseEntity<PositionEntity>(service.savePosition(position),HttpStatus.CREATED);
	}
	
//	@GetMapping("/all")
//	public List<PositionEntity> getAllPosition(){
//		return service.listPosition();
//	}
//	
	@GetMapping("/{id}")
	public ResponseEntity<PositionEntity> getPositionById(@PathVariable("id") int id){
		return new ResponseEntity<PositionEntity>(service.getPositionById(id),HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<PositionEntity> updatePosition(@PathVariable("id") int id, 
			@RequestBody PositionEntity position){
		return new ResponseEntity<PositionEntity>(service.updatePosition(position, id),HttpStatus.OK);
	}
	
	@GetMapping("/newall")
	public List<PositionEntity> findAllQ(){
		return service.FindAllQ();
	}
	
	@PutMapping("/delete/{id}")
	public ResponseEntity<PositionEntity> deletePosition(@PathVariable("id") int id, 
			 PositionEntity position){
		return new ResponseEntity<PositionEntity>(service.deletePosition(id, position),HttpStatus.OK);
	}

}
