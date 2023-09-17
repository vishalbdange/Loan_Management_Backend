package com.example.loan_management_backend_new.entities;
import java.time.LocalDate;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Past;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Employees")
@Getter
@Setter

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employee_id;


    @Column(nullable =false)
    private String employee_password;

    @Column(nullable =false)
    private String employee_name;

    @Column(nullable =false)
    private String gender;

    @Column(nullable =false)
    @Max(value = 60,message = "Age Should be between 18 and 60")
    @Min(value = 18,message = "Age Should be between 18 and 60")
    private int age;

    @Column(nullable = false)
    private double salary;

    @Column(nullable =false)
    @Email(message = "Invalid Email Id")
    private String email;

    @Column(nullable =false)
    @PastOrPresent(message="Date of joining should be in past or present")
    private LocalDate doj;

    @Column(nullable =false)
    @Pattern(regexp = "[9876][0-9]{9}",message = "Mobile number is invalid")
    private String mobile;


    private String roles;


}