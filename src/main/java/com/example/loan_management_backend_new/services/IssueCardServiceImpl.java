package com.example.loan_management_backend_new.services;


import com.example.loan_management_backend_new.entities.IssueCard;
import com.example.loan_management_backend_new.repositories.IssueCardRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@Service
public  class IssueCardServiceImpl implements IssueCardService{
    @Autowired
    private IssueCardRepository issueCardRepository;


    public void setIssueCardRepository(IssueCardRepository issueCardRepository) {
        this.issueCardRepository = issueCardRepository;
    }


    @Override
    public IssueCard addIssueCard(IssueCard issue_card) {
        // TODO Auto-generated method stub
        return issueCardRepository.save(issue_card);

    }

    @Override
    public IssueCard getIssueCardById(int id) {
        // TODO Auto-generated method stub
        return issueCardRepository.findById(id).orElse(null);
    }

    @Override
    public List<IssueCard> getAllIssueCards() {
        // TODO Auto-generated method stub
        return  issueCardRepository.findAll();
    }

    @Override
    public void removeIssueCard(IssueCard issue_card) {
        // TODO Auto-generated method stub
        issueCardRepository.delete(issue_card);

    }

}