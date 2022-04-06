package com.rangga.services;

import java.util.List;
import java.util.Optional;

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

	
	public List<karyawanModel>getAllData() {
		return kr.findAll();
	}
	
	public String insertData(karyawanModel model) {
		kr.save(model);
		return "Berhasil";
	}
	
	public String update(karyawanModel model) {
		kr.save(model);
		return "Berhasil";
	}
	
	public karyawanModel getById(int id)
    {
        Optional<karyawanModel> optional = kr.findById(id);
        karyawanModel karyawan = null;
        if (optional.isPresent())
            karyawan = optional.get();
        else
            throw new RuntimeException(
                "Employee not found for id : " + id);
        return karyawan;
    }
	
	public void deleteViaId(int id)
    {
        kr.deleteById(id);
    }

}
