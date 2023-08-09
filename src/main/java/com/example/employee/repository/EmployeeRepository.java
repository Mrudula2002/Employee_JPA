package com.example.employee.repository;

import com.example.employee.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    //all crud methods
    //Employee findByNameIgnoreCase(String name);
    List<Employee> findByName(String name);
}
