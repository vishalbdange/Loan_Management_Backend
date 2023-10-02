package com.example.loan_management_backend_new.entities;
import java.time.LocalDate;

import org.hamcrest.Matcher;

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
	 public Employee(int i, String password, String name, String gender, int age, double salary, String email,LocalDate ld, String contactnumber) {
			// TODO Auto-generated constructor stub
	    	this.employeeId=i;
	    	this.employeeName=name;
	    	this.gender=gender;
	    	this.employeePassword=password;
	    	this.age=age;
	    	this.salary=salary;
	    	this.doj=ld;
	    	this.mobile=contactnumber;
	    	this.email=email;
		}


	@Id
    private int employeeId;


    @Column(nullable =false)
    private String employeePassword;

    @Column(nullable =false)
    private String employeeName;

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


    private String role="User";


	
    



}