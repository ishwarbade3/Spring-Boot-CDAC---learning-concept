package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.EmployeeRepository;
import com.app.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImp implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> findAll() {
		return employeeRepository.findAll();

	}

	public Employee findById(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> e = employeeRepository.findById(id);
		Employee emp = null;
		if (e.isPresent()) {
			emp = e.get();
		} else {
			throw new RuntimeException("Did not find employee with id " + id);
		}
		return emp;
	}

	@Transactional
	public void deleteEmployee(int id) {
		Optional<Employee> e = employeeRepository.findById(id);
		
		if(e.isPresent()) {
		employeeRepository.deleteById(id);	
		}
		else {
			throw new RuntimeException("Did not find employee with id " + id);
		}

		//employeeRepository.deleteById(id);
	}

	@Transactional
	public void saveEmployee(Employee e) {
		employeeRepository.save(e);
	}

}
