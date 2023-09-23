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
@Table(name="ItemDetails")
@Getter
@Setter

public class ItemDetails {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;

    @NotBlank(message = "Item category is required")
    @Size(min = 1, max = 25, message = "Item category length should be between 1 and 25 characters")
    private String itemCategory;

    @NotBlank(message = "Item description is required")
    @Size(min = 1, max = 25, message = "Item description length should be between 1 and 50 characters")
    private String itemDescription;

    @NotNull
    private double itemValue;
    
    @NotBlank(message = "Item make is required")
    @Size(min = 1, max = 25, message = "Item make should be between 1 and 10 characters")
    private String itemMake;


    @NotBlank
    @Pattern(regexp = "(Pending|Approved|Rejected)", message = "Status can only be pending, approved or rejected")
    private String itemStatus = "Pending";



}