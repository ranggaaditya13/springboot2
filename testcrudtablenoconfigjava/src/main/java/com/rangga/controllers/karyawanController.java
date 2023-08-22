package com.rangga.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rangga.models.karyawanModel;
import com.rangga.services.karyawanService;

@RestController
public class karyawanController {
	
	@Autowired
	private karyawanService ks;
	
	@GetMapping("/getall")
	public List<karyawanModel> getAll(){
		return ks.alldata();
	}

}
