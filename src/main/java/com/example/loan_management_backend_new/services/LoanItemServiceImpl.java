package com.example.loan_management_backend_new.services;


import java.util.List;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loan_management_backend_new.entities.LoanItem;
import com.example.loan_management_backend_new.repositories.LoanItemRepository;

@Getter
@Setter
@Service
public  class LoanItemServiceImpl implements LoanItemService{
    @Autowired
    private LoanItemRepository loanItemRepository;


    public void setLoanItemRepository(LoanItemRepository loanItemRepository) {
        this.loanItemRepository = loanItemRepository;
    }


    @Override
    public LoanItem addLoanItem(LoanItem loan_item) {
        // TODO Auto-generated method stub
        return loanItemRepository.save(loan_item);

    }

    @Override
    public LoanItem getLoanItemById(int id) {
        // TODO Auto-generated method stub
        return loanItemRepository.findById(id).orElse(null);
    }

    @Override
    public List<LoanItem> getAllLoanItems() {
        // TODO Auto-generated method stub
        return  loanItemRepository.findAll();
    }

    @Override
    public void removeLoanItem(LoanItem loan_item) {
        // TODO Auto-generated method stub
        loanItemRepository.delete(loan_item);

    }

}