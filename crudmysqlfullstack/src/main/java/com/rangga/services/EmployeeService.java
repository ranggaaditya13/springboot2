package com.rangga.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rangga.models.EmployeeModel;
import com.rangga.repositories.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository ep;
	
	public List<Map<String, Object>> listEmployee(){
		return ep.listEmployee();
	}
	
	public int insertData(String nama,String jenis_kelamin,String telephone) {
		return ep.insert(nama, jenis_kelamin, telephone);
	}
	
	public int UpdateData(String nama,String jenis_kelamin,String telephone, int id) {
		return ep.updateData(nama, jenis_kelamin, telephone, id);
	}
	
	public int deleteData(int id) {
		return ep.deleteData(id);
	}

	public EmployeeModel getById(int id)
	    {
	        Optional<EmployeeModel> optional = ep.findById(id);
	        EmployeeModel employee = null;
	        if (optional.isPresent())
	            employee = optional.get();
	        else
	            throw new RuntimeException(
	                "Employee not found for id : " + id);
	        return employee;
	    }
	  
	public void deleteViaId(int id)
	    {
	        ep.deleteById(id);
	    }

}
