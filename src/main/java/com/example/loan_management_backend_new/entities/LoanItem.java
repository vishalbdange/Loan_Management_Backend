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
import org.hibernate.annotations.Parameter;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="LoanItem")
@Getter
@Setter

public class LoanItem {


    @NotNull
    private int employeeId;

    @NotBlank(message = "Item category is required")
    @Size(min = 1, max = 25, message = "Item category length should be between 1 and 25 characters")
    private String itemCategory;

    @NotBlank(message = "Item description is required")
    @Size(min = 1, max = 25, message = "Item description length should be between 1 and 50 characters")
    private String itemDescription;

    @NotBlank(message = "Item make is required")
    @Size(min = 1, max = 25, message = "Item make length should be between 1 and 50 characters")
    private String itemMake;

    @NotNull
    private double itemValue;

    @NotBlank
    @Pattern(regexp = "(Pending|Approved|Rejected)", message = "Status can only be pending, approved or rejected")
    private String loanStatus = "Pending";

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loanId;

    @Column(nullable = false)
    @NotBlank
    private String loanType;



    @NotNull
    @Min(value = 1, message = "Loan duration should be greater than or equal to 1")
    private int loanDuration=1;

    private LocalDate applyDate = LocalDate.now();

    private LocalDate issueDate = LocalDate.now();
}