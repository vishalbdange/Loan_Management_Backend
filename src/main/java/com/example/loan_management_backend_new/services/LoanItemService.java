package com.example.loan_management_backend_new.services;

import java.util.List;

import com.example.loan_management_backend_new.entities.LoanItem;


public interface LoanItemService {

    public LoanItem addLoanItem(LoanItem loan_item);
    public LoanItem getLoanItemById(int id);

    public List<LoanItem> getLoanItemsByEmployeeId(int username);
     public List<LoanItem> getAllLoanItems();
    public void removeLoanItem(LoanItem loan_item);
}