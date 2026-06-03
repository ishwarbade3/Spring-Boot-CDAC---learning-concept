package com.app.service;

import java.util.List;

import com.app.entity.Employee;

public interface EmployeeService {
	public int getEmpCount();

	public List<Employee> findByFirstName(String fname);

	public String updateLastName(int id, String lname);

}
