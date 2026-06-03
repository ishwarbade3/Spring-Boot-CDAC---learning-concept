package com.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Employee;
import com.app.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmploueeRestController {
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee theEmployee) {
		employeeService.saveEmployee(theEmployee);
		return theEmployee;
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
		Employee e = employeeService.getEmployeeById(id);
		if (e == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(e, HttpStatus.FOUND);

		}
	}

	@PutMapping("/employees")

	public ResponseEntity<String> updateEmployee(@RequestBody Employee theEmployee) {

		Employee e = employeeService.getEmployeeById(theEmployee.getId());

		if (e == null) {
			return new ResponseEntity<String>("Employee Not Found with id " + theEmployee.getId(),
					HttpStatus.NOT_FOUND);
		} else {
			employeeService.updateEmployee(theEmployee);
			return new ResponseEntity<String>("Employee Update SucessFully with id " + theEmployee.getId(),
					HttpStatus.FOUND);

		}

	}

	@DeleteMapping("employees/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
		Employee e = employeeService.getEmployeeById(id);

		if (e == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			employeeService.deleteEmployee(e);

			return new ResponseEntity<Void>(HttpStatus.OK);

		}
		// employeeService.deleteEmployee(e);
	}

}
