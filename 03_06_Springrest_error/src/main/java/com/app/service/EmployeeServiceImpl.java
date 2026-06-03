package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DAO.EmployeeDAO;
import com.app.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public int getEmpCount() {
        return employeeDAO.getEmployeeCount();
    }

    @Override
    public List<Employee> findByFirstName(String str) {
        return employeeDAO.findByFirstName(str);
    }

    @Override
    public String updateLastName(int id, String lname) {
        int i = employeeDAO.updateLastName(id, lname);
        if (i >= 0) {
            return "Employee Updated";
        } else {
            return "Failed to Update";
        }
    }
}
