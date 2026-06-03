package com.app.service;

import java.util.List;

import com.app.entity.Employee;

public interface EmployeeService {
	public void saveEmployee(Employee e);

	public List<Employee> getAllEmployee();

	public Employee getEmployeeById(int id);

	public Employee updateEmployee(Employee e);

	public void deleteEmployee(Employee e);

}
