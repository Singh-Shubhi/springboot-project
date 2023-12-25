package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.EmployeeModel;
import com.employee.repo.EmployeeRepo;

// jpa provide save method to work easily no create logic for save
@Service
public class EmployeeService implements ServicrInf {

	@Autowired
	EmployeeRepo repo;
	@Override
	public String saveEmployee(EmployeeModel employee) {
		try {
			repo.save(employee);
			return "Employee Details stored for id: "+employee.getId();
		}catch(Exception e) {
			System.out.println(e);
			return "Something went wrong";
		}
	
	}
	@Override
	public List<EmployeeModel> getEmployees() {
		try {
//			return repo.findAll();
//			the below logic for fetch data using query 
			return repo.fetchAllEmployees();
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	@Override
	public List<EmployeeModel> deleteEmployees(int id) {
		try {
			repo.deleteById(id);
			return repo.findAll();
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	@Override
	public EmployeeModel updateEmployees(EmployeeModel employees) {
		try {
			repo.save(employees);
//			return repo.findById(employees.getId()).get();
			return repo.getById(employees.getId());
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	@Override
	public List<EmployeeModel> findByNameAndSurname(String name, String surname) {
		
		return repo.findByNameAndSurname(name, surname);
	}
	@Override
	public List<EmployeeModel> findDistinctEmployee(String name) {
		
		return repo.findDistinctEmployeeByName(name);
	}
	

}
