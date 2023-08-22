package com.rangga.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rangga.models.KaryawanModel;
import com.rangga.services.karyawanService;

@RestController
public class karyawanController {
	
	@Autowired
	private karyawanService ks;
	
	
	@GetMapping("/data")
	public List<KaryawanModel> allData(){
		return ks.allData();
	}

	@GetMapping("/insert")
	public String insertData(KaryawanModel model) {
		model.setId(10);
		model.setNama("Rangga");
		model.setGender("Laki-Laki");
		model.setAlamat("Aceh");
		model.setEmail("ranggaaditya@yahoo.com");
		model.setNo_hp("082222222222");
		
		ks.insert(model);
		return "berhasil";
	}
	
	@GetMapping("/hapus/{id}")
	public void delete(@PathVariable int id) {
		 ks.hapus(id);
	}
}
