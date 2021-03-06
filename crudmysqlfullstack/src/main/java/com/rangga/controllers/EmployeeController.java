package com.rangga.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rangga.models.EmployeeModel;
import com.rangga.services.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService es;
	//test
	
	@GetMapping("all")
	public List<Map<String, Object>> listEmployee(){
		return es.listEmployee();
	}
	
	@PostMapping(value = "/post")
	public int insert(EmployeeModel em) {
		//kalau masih perlu testing di Postman, gunakan @RequestBody Di model diatas
		int i = 0;
		try {
			es.insertData(em.getNama(),em.getJenis_kelamin(),em.getTelephone());
			i = 1;		
		} catch (Exception e) {
			
		}
		return i;
	}
	
	@PutMapping("/update")
	public int update(@RequestBody EmployeeModel em) {
		int i = 0;
		try {
			es.UpdateData(em.getNama(),em.getJenis_kelamin(),em.getTelephone(),em.getId());
			i = 1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return i;
	}

	@DeleteMapping("/delete")
	public int delete(@RequestBody EmployeeModel em) {
		int i = 0;
		try {
			es.deleteData(em.getId());
			i = 1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return i;
	}
}
