package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Employee;
import com.app.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public String saveEmployee(@Validated @RequestBody Employee e) {
        return "Employee saved successfully!";
    }

    @GetMapping("/employees/count")
    public String getEmployeeCount() {
        return "employeeCount: " + employeeService.getEmpCount();
    }

    @GetMapping("/employees/first")
    public List<Employee> findByFirstName(@RequestParam String firstName) {
        return employeeService.findByFirstName(firstName);
    }

    @PutMapping("/employees/modify/{id}")
    public String updateLastName(@PathVariable int id, @RequestParam String lname) {
        return employeeService.updateLastName(id, lname);
    }
}
