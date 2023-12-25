package com.employee.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.EmployeeModel;
import com.employee.service.ServicrInf;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	
	@Autowired
	ServicrInf service;
	
	@PostMapping("/save")
	public String saveEmployee(@RequestBody EmployeeModel employee) {
		return service.saveEmployee(employee);
		
	}
	
	@GetMapping("/fetch")
	public List<EmployeeModel> getEmployee(){
		return service.getEmployees();
	}
	
	@DeleteMapping("/delete/{id}")
	public List<EmployeeModel> deleteEmployee(@PathVariable int id){
		return service.deleteEmployees(id);
	}
	
	@PutMapping("/update")
	public EmployeeModel updateEmployee(@RequestBody EmployeeModel employees){
		return service.updateEmployees(employees);
	}
	
	@GetMapping("/fetch/{name}/{surname}")
	public List<EmployeeModel> findByNameAndSurname(@PathVariable String name, @PathVariable String surname){
		return service.findByNameAndSurname(name,surname);
	}
	
	@GetMapping("/fetch/{name}")
	public List<EmployeeModel> findDistinctEmployeeByName(@PathVariable String name){
		return service.findDistinctEmployee(name);
	}
	
	
	
	
	
	

}
