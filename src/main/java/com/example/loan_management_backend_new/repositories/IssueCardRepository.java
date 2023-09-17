package com.example.loan_management_backend_new.repositories;

import com.example.loan_management_backend_new.entities.IssueCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueCardRepository extends JpaRepository<IssueCard, Integer> {

}