package com.example.loan_management_backend_new.entities;
import java.time.LocalDate;


import jakarta.validation.constraints.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="IssueCard")
@Getter
@Setter

public class IssueCard
{
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int issue_id;


    private int employee_id;



    private int item_id=345;

    @Future(message="Return date should be in future")
    private LocalDate return_date;

    private LocalDate issue_date;
}