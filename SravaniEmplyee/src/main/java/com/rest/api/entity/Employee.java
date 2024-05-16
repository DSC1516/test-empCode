package com.rest.api.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Pattern;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="EMP_Details")
public class Employee {
	
	
	public LocalDate getDoj() {
		return doj;
	}
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@NotBlank(message="Firstname can not be empty")
	String firstName;
	String lastName;
	
	//@Email
	@Pattern(regexp="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message="invalid mail")
	String email;
	@Size(min=10,max=10,message= "Phone number must be contain 10 numbers")
	List<Integer> phoneNumber;
	@Temporal(TemporalType.DATE)
	LocalDate doj;
	@NotBlank(message="at least give minimum wageas")
	int salary;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Integer> getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(List<Integer> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Employee(int id2, String firstName2, String lastName2, String email2, List<Integer> phoneNumber2,
			LocalDate doj2, LocalDate doj3, int salary2) {
		// TODO Auto-generated constructor stub
	}
	
}
