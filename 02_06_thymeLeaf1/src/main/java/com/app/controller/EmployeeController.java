package com.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.entity.Employee;
import com.app.service.EmployeeService;

import jakarta.transaction.Transactional;

@Controller
//@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@GetMapping("/list")
	// @RequestMapping(path = "/list",method = RequestMethod.GET)
	public String listEmp(Model theModel) {
		List<Employee> list = employeeService.findAll();
		theModel.addAttribute("employee", list);
		System.out.println(list);
		return "employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Employee e = new Employee();

		theModel.addAttribute("employee", e);
		return "employees/employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee e) {
		employeeService.saveEmployee(e);
		return "redirect:/list";
	}

	@GetMapping("/updateEmployee")
	public String updateEmployee(@RequestParam("employeeId") int id, Model theModel) {
		Employee e = employeeService.findById(id);

		theModel.addAttribute("employee", e);
		return "employees/employee-form";
	}

	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("employeeId") int id) {
		employeeService.deleteEmployee(id);

		return "redirect:/list";
	}
}
