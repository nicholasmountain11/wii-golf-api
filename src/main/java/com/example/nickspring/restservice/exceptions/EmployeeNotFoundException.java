package com.example.nickspring.restservice.exceptions;

public class EmployeeNotFoundException extends RuntimeException{
    EmployeeNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}
