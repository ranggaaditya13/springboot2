package com.rangga.services;

import java.util.List;

import com.rangga.entity.EmployeeEntity;

public interface EmployeeService {
	
	EmployeeEntity saveEmployee(EmployeeEntity employee);
	EmployeeEntity getEmployeeById(int id);
	EmployeeEntity updateEmployee(EmployeeEntity employee, int id);
	List<EmployeeEntity> FindAllQ();
	EmployeeEntity deleteEmployee(int id, EmployeeEntity employee);

}
