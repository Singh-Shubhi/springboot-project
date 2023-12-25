package com.employee.service;

import java.util.List;

import com.employee.model.EmployeeModel;

public interface ServicrInf {

	
	public String saveEmployee(EmployeeModel employee);

	public List<EmployeeModel> getEmployees();

	public List<EmployeeModel> deleteEmployees(int id);

	public EmployeeModel updateEmployees(EmployeeModel employees);

	public List<EmployeeModel> findByNameAndSurname(String name, String surname);

	public List<EmployeeModel> findDistinctEmployee(String name);

	
}
