package com.example.loan_management_backend_new.repositories;

import com.example.loan_management_backend_new.entities.LoanItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanItemRepository extends JpaRepository<LoanItem, Integer> {

}