package com.example.loan_management_backend_new.services;

import com.example.loan_management_backend_new.entities.IssueCard;

import java.util.List;


public interface IssueCardService {

    public IssueCard addIssueCard(IssueCard issue_card);
    public IssueCard getIssueCardById(int id);
    public List<IssueCard> getAllIssueCards();
    public void removeIssueCard(IssueCard issue_card);
}