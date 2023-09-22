package com.example.loan_management_backend_new.services;

import com.example.loan_management_backend_new.repositories.EmployeeRepository;
import com.example.loan_management_backend_new.entities.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;



    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }
    public List<Employee> getAllEmployees () {
        return employeeRepository.findAll();
    }

    @Override
    public void removeEmployee(Employee toBeDeleted) {
        employeeRepository.delete(toBeDeleted);
    }

}