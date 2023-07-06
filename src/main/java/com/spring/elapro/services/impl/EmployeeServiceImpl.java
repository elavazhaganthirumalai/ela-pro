package com.spring.elapro.services.impl;

import com.spring.elapro.models.Employee;
import com.spring.elapro.repositories.EmployeeRepository;
import com.spring.elapro.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public Employee createNewEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee updateExistingEmployee(Long id, Employee employee) {
        Employee employeeById=getEmployeeById(id);
        if (employeeById != null) {
            employeeById.setName(employee.getName());
            employeeById.setEmail(employee.getEmail());
            employeeById.setSalary(employee.getSalary());
            employeeById.setMobileNumber(employee.getMobileNumber());
            return createNewEmployee(employeeById);
        }
        return null;
    }

    @Override
    public Employee removeEmployee(Long id) {
        Employee employeeById=getEmployeeById(id);
        if (employeeById!=null) {
            employeeRepository.delete(employeeById);
        }
        return employeeById;
    }
}
