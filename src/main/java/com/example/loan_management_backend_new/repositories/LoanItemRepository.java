package com.example.loan_management_backend_new.repositories;

import com.example.loan_management_backend_new.entities.LoanItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LoanItemRepository extends JpaRepository<LoanItem, Integer> {
   List<LoanItem> findByEmployeeId(Integer username);

}