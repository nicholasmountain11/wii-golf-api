package com.example.nickspring.restservice.repositories;

import com.example.nickspring.restservice.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
