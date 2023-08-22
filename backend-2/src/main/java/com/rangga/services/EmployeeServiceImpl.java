package com.rangga.services;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.SimpleFormatter;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import com.rangga.entity.EmployeeEntity;
import com.rangga.exception.ResourceNotFoundException;
import com.rangga.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository repo;

	public EmployeeServiceImpl(EmployeeRepository repo) {
		super();
		this.repo = repo;
	}



	@Override
	public EmployeeEntity saveEmployee(EmployeeEntity employee) {
		return repo.save(employee);
	}

//	@Override
//	public List<employeeEntity> listemployee() {
//		return repo.findAll();
//	}

	@Override
	public EmployeeEntity getEmployeeById(int id) {
		return repo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("employee", "id", id));
	}

	/**
	 *
	 */
	@Override
	@DateTimeFormat(pattern = "yyyy.MM.dd")
	public EmployeeEntity updateEmployee(EmployeeEntity employee, int id) {	
		Date date = employee.getBirthDate();
		EmployeeEntity haveEmployee = repo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("employee", "id", id));
		haveEmployee.setName(employee.getName());
		haveEmployee.setBirthDate(date);
		haveEmployee.setPositionId(employee.getPositionId());
		haveEmployee.setIdNumber(employee.getIdNumber());
		haveEmployee.setGender(employee.getGender());
		haveEmployee.setIsDeteled(0);
		repo.save(haveEmployee);
		return haveEmployee;
	}

	@Override
	public List<EmployeeEntity> FindAllQ() {
		return repo.newList();
	}



	@Override
	public EmployeeEntity deleteEmployee(int id, EmployeeEntity employee) {
		EmployeeEntity haveEmployee = repo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("employee", "id", id));	
		haveEmployee.setIsDeteled(1);
		repo.save(haveEmployee);
		return haveEmployee;
	}









	

}
