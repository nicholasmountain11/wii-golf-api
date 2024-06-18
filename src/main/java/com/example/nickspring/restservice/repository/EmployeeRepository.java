package com.example.nickspring.restservice.repository;

import com.example.nickspring.restservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
