package com.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class EmployeeDAOImp implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;

	public void saveEmployee(Employee e) {
		entityManager.persist(e);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployee() {

		Query query = entityManager.createQuery("from Employee");
		List<Employee> list = query.getResultList();
		return list;

		// return entityManager.createQuery("from Empoyee").getResultList();
	}

	public Employee getEmployeeById(int id) {

		return entityManager.find(Employee.class, id);
	}

	@Override
	public Employee updateEmployee(Employee e) {

		return entityManager.merge(e);
	}

	@Override
	public void deleteEmployee(Employee e) {
		entityManager.remove(e);

	}

}
