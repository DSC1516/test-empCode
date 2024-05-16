package com.rest.api.services.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.api.ResourseNotFoundException;
import com.rest.api.entity.Employee;
import com.rest.api.repository.EmployeeRepository;
import com.rest.api.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepository;
	@Override
	public Employee saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		
		return empRepository.save(emp);
	}

	@Override
	public List<Employee> getallEmployees() {
		// TODO Auto-generated method stub
		return empRepository.findAll();
	}

	@Override
	public Optional<Employee> getEmployee(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> emp=Optional.ofNullable(empRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException("Given employee is is not found")));
		return emp;
	}
	private Employee calculateTaxDetails(Employee employee) {
		LocalDate startOfFinicialYear= LocalDate.now()
		        .withMonth(4)
		        .withDayOfMonth(1);
		LocalDate endOfFinancialYear = LocalDate.now()
		        .plusYears(1)
		        .withMonth(3)
		        .withDayOfMonth(31);
		LocalDate doj=employee.getDoj();
		
		double yearlySalary=0;
		if(doj.isAfter(endOfFinancialYear)) {
			yearlySalary=0;
		}else if(doj.isBefore(startOfFinicialYear)){
			yearlySalary=employee.getSalary()*12;
		}else {
			long monthWorked=ChronoUnit.MONTHS.between(doj.withMonth(1), endOfFinancialYear.withMonth(1));
			yearlySalary=employee.getSalary()*monthWorked;
		}
		
		double taxAmount=calculateTax(yearlySalary);
		double cessAmount=calculateCess(yearlySalary);		
		return new Employee(employee.getId(),employee.getFirstName(),employee.getLastName(),employee.getEmail(),employee.getPhoneNumber(),employee.getDoj(),employee.getDoj(),employee.getSalary());
	}
	private double calculateTax(double yearlySalary) {
		
		double tax=0;
		if(yearlySalary>250000) {
			if(yearlySalary<=500000) {
				tax=(yearlySalary-250000)*0.05;
			}else if(yearlySalary<=1000000) {
				tax=250000*0.05;
				tax=tax+(yearlySalary-500000)*0.1;
			}else if(yearlySalary>1000000) {
				tax=250000*0.05;
				tax=tax+(yearlySalary-500000)*0.1;
				tax=tax+(yearlySalary-1000000)*0.2;
			}
			
		}
		return tax;
	}
	private double calculateCess(double yearlySalary) {
		double cess=0;
		if(yearlySalary>2500000) {
			cess=(yearlySalary-2500000)*0.02;
		}
		return cess;
	}
}
