package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.EmployeeDAO;
import com.app.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Transactional
	public void saveEmployee(Employee e) {
		employeeDAO.saveEmployee(e);
	}

	public List<Employee> getAllEmployee() {
		return employeeDAO.getAllEmployee();
	}

	public Employee getEmployeeById(int id) {

		return employeeDAO.getEmployeeById(id);
	}

	@Transactional
	public Employee updateEmployee(Employee e) {
		return employeeDAO.updateEmployee(e);
	}

	@Transactional
	public void deleteEmployee(Employee e) {
		employeeDAO.deleteEmployee(e);

	}

}
