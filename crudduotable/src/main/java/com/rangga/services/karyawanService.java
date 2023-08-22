package com.rangga.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rangga.models.karyawanModel;
import com.rangga.repositories.karyawanRepository;

@Service
@Transactional
public class karyawanService {
	
	@Autowired
	private karyawanRepository kr;
	
	public List<karyawanModel> alldata() {
		return kr.findAll();
		
	}

}
