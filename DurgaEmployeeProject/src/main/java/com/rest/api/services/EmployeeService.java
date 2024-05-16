package com.rest.api.services;

import java.util.List;
import java.util.Optional;

import com.rest.api.entity.Employee;

public interface EmployeeService {
//for create
	Employee saveEmployee(Employee emp);
	
//get All user
	List<Employee> getallEmployees();
// get single Employee
	public Optional<Employee> getEmployee(int id);
}
