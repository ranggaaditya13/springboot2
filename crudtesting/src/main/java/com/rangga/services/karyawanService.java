package com.rangga.services;

import org.springframework.transaction.annotation.Transactional;

import com.rangga.models.KaryawanModel;
import com.rangga.repositories.KaryawanRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class karyawanService {
	
	@Autowired
	private KaryawanRepository kr;
	
	public List<KaryawanModel> allData(){
		return kr.allData();
	}
	
	public String insert(KaryawanModel model) {
		kr.save(model);
		return "berhasil";
	}
	
	public void hapus(int id) {
	 kr.deleteById(id);
	}

}
