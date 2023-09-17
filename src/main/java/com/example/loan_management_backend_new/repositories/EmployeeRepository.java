package com.example.loan_management_backend_new.repositories;

import com.example.loan_management_backend_new.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}