package com.example.loan_management_backend_new.services;

import java.util.List;

import com.example.loan_management_backend_new.entities.Employee;

public interface EmployeeService {

    public Employee addEmployee(Employee employee);
    public Employee getEmployeeById(int id);
    public List<Employee> getAllEmployees();
    public void removeEmployee(Employee employee);
}