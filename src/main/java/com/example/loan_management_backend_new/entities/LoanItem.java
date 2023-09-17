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
@Table(name="LoanItem")
@Getter
@Setter

public class LoanItem {


    @NotNull
    private int employee_id;

    @NotBlank(message = "Item category is required")
    @Size(min = 1, max = 25, message = "Item category length should be between 1 and 25 characters")
    private String item_category;

    @NotBlank(message = "Item description is required")
    @Size(min = 1, max = 25, message = "Item description length should be between 1 and 50 characters")
    private String item_description;

    @NotNull
    private double item_value;

    @NotBlank
    @Pattern(regexp = "(Pending|Approved|Rejected)", message = "Status can only be pending, approved or rejected")
    private String item_status = "Pending";

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loan_id;

    @Column(nullable = false)
    @NotBlank
    private String loan_type;

    @NotNull
    @Min(value = 1, message = "Loan duration should be greater than or equal to 1")
    private int item_duration;

    private LocalDate apply_date = LocalDate.now();
}