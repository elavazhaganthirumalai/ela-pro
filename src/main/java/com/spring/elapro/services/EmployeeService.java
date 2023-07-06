package com.spring.elapro.services;

import com.spring.elapro.models.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee createNewEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Employee getEmployeeById(Long id);
    Employee updateExistingEmployee(Long id,Employee employee);
    Employee removeEmployee(Long id);
}
