package com.app.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entity.Employee;

import jakarta.transaction.Transactional;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

    @Query("select count(id) from Employee")
    int getEmployeeCount();

    List<Employee> findByFirstName(String firstName);

   @Modifying 
    @Transactional
    @Query("update Employee e SET e.lastName = :lname WHERE id = :id")
    int updateLastName(@Param("id") int id, @Param("lname") String lname);
}
