package com.spring.elapro.controllers;

import com.spring.elapro.bean.ResponseBean;
import com.spring.elapro.models.Employee;
import com.spring.elapro.repositories.EmployeeRepository;
import com.spring.elapro.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v4/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<ResponseBean> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.createNewEmployee(employee);
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMessage("Employee [" + savedEmployee.getName() + "] Created Successfully");
        return ResponseEntity.status(201).body(responseBean);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employeeList = employeeService.getAllEmployee();
        return ResponseEntity.status(200).body(employeeList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable Long id) {
        Employee employeeById = employeeService.getEmployeeById(id);
        if (employeeById != null) {
            return ResponseEntity.status(200).body(employeeById);
        } else {
            ResponseBean responseBean = new ResponseBean();
            responseBean.setMessage("Employee [" + id + "] Not Exists");
            return ResponseEntity.status(404).body(responseBean);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateExistingEmployee(id, employee);
        if (updatedEmployee != null) {
            return ResponseEntity.status(200).body(updatedEmployee);
        } else {
            ResponseBean responseBean = new ResponseBean();
            responseBean.setMessage("Employee [" + id + "] Not Exists");
            return ResponseEntity.status(404).body(responseBean);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id){
        Employee employee=employeeService.removeEmployee(id);
        if (employee!=null) {
            ResponseBean responseBean = new ResponseBean();
            responseBean.setMessage("Employee [" + id + "] Deleted");
            return ResponseEntity.status(200).body(responseBean);
        }else {
            ResponseBean responseBean = new ResponseBean();
            responseBean.setMessage("Employee [" + id + "] Not Exists");
            return ResponseEntity.status(404).body(responseBean);
        }
    }
}
