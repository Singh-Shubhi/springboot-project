package com.employee.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee.model.EmployeeModel;

//Repository is interface
//<> triangular bracket called generic inside 1st para is jiska class ka repo bana h usko naam, 2nd jo column unique h usko data type ka wrapper class
// repository extends krega jparepo interface ko

public interface EmployeeRepo extends JpaRepository<EmployeeModel, Integer>{
	
	public List<EmployeeModel> findByNameAndSurname(String name,String surname);
//	jpa interpreted this method automatically but this method name should be in meaningful.
	
	public List<EmployeeModel> findDistinctEmployeeByName(String name);
	
//	@Query(value="SELECT e FROM EMPLOYEEMODEL e") ....jpql (java persistance query language)
	
	@Query(value="select * from employee_model", nativeQuery = true)
	public List<EmployeeModel> fetchAllEmployees();
	
	@Query(value="select * from employee_model where id=:id", nativeQuery = true)
	public EmployeeModel getById(@Param("id") Integer id );	
	
	
	

}
