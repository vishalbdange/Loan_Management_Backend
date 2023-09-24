package com.example.loan_management_backend_new.repositories;

import com.example.loan_management_backend_new.entities.ItemDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDetailsRepository extends JpaRepository<ItemDetails, Integer> {

}