package com.rangga.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rangga.models.karyawanModel;
import com.rangga.services.karyawanService;

@RestController
public class karyawanController {
	
	@Autowired
	private karyawanService ks;
	
	@GetMapping("/all")
	public List<karyawanModel> getAllData(){
		return ks.getAllData();
	}
	
	@RequestMapping("/add")
	public String insertData(@RequestBody karyawanModel km) {
		km.getNama();
		km.getGender();
		km.getAlamat();
		km.getEmail();
		km.getNo_hp(); 	
		ks.insertData(km);
		return "Berhasil";
	}

}
