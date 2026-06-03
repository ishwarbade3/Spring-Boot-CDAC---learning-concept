package com.app.service;

import java.util.List;

import com.app.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	public Employee findById(int id);
	public void deleteEmployee(int id);
	public void saveEmployee(Employee e);

}
