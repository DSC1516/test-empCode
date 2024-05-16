package com.rest.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.entity.Employee;
import com.rest.api.services.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmpController {
	@Autowired
	private EmployeeService empService;
	
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp){
		Employee emp1=empService.saveEmployee(emp);
		return ResponseEntity.status(HttpStatus.CREATED).body(emp1);
	}
	
//Getting Single Employee detail
	@GetMapping("/{empId}")
	public ResponseEntity<Optional<Employee>> getSingleEmployeeDetails(@PathVariable ("empId") int id){
		Optional<Employee> employee=empService.getEmployee(id);
		return ResponseEntity.ok(employee);
	}
	
}
