package com.spring.elapro.models;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;
    @Column(name = "employee_name")
    private String name;
    @Column(name = "employee_salary")
    private Long salary;
    @Column(name = "employee_mobile_number")
    private Long mobileNumber;
    @Column(name = "employee_email")
    private String email;

    public Employee() {
    }

    public Employee(Long id, String name, Long salary, Long mobileNumber, String email) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", mobileNumber=" + mobileNumber +
                ", email='" + email + '\'' +
                '}';
    }
}
