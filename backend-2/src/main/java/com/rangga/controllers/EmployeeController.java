package com.rangga.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rangga.entity.EmployeeEntity;
import com.rangga.entity.PositionEntity;
import com.rangga.services.EmployeeService;
import com.rangga.services.PositionService;

@RestController
@RequestMapping("emp")
public class EmployeeController {
	
	private EmployeeService service;

	public EmployeeController(EmployeeService service) {
		super();
		this.service = service;
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<EmployeeEntity> saveEmployee(@RequestBody EmployeeEntity employee){
		return new ResponseEntity<EmployeeEntity>(service.saveEmployee(employee),HttpStatus.CREATED);
	}
	
//	@GetMapping("/all")
//	public List<EmployeeEntity> getAllEmployee(){
//		return service.listEmployee();
//	}
//	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("id") int id){
		return new ResponseEntity<EmployeeEntity>(service.getEmployeeById(id),HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable("id") int id, 
			@RequestBody EmployeeEntity employee){
		return new ResponseEntity<EmployeeEntity>(service.updateEmployee(employee, id),HttpStatus.OK);
	}
	
	@GetMapping("/newall")
	public List<EmployeeEntity> findAllQ(){
		return service.FindAllQ();
	}
	
	@PutMapping("/delete/{id}")
	public ResponseEntity<EmployeeEntity> deleteEmployee(@PathVariable("id") int id, 
			 EmployeeEntity employee){
		return new ResponseEntity<EmployeeEntity>(service.deleteEmployee(id, employee),HttpStatus.OK);
	}

}
