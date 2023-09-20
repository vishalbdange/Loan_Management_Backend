package com.example.loan_management_backend_new.controller;

import java.util.List;

import com.example.loan_management_backend_new.entities.LoginData;
import com.example.loan_management_backend_new.config.SecurityConfig;
import com.example.loan_management_backend_new.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.loan_management_backend_new.entities.LoginData;
import com.example.loan_management_backend_new.services.LoginDataService;
import com.example.loan_management_backend_new.services.UserInfoService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import jakarta.validation.Valid;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/logindata")
public class LoginDataController {
    @Autowired
    private LoginDataService loginDataService;

    @Autowired
    private UserInfoService userinfoservice;

    @Autowired
    private SecurityConfig security;;
    @PostMapping("/add")
//    public ResponseEntity<UserDetails> addLoginData(@Valid @RequestBody LoginData loginData) {
    public ResponseEntity<String> addLoginData(@Valid @RequestBody LoginData loginData) {
//        LoginData loginData1 = loginDataService.addLoginData(loginData);

        UserDetails user_details = userinfoservice.loadUserByUsername(String.valueOf(loginData.getUsername()));
        System.out.print(user_details.getPassword());

        
        String encrypted_password = security.passwordEncoder().encode(loginData.getPassword());
         return new ResponseEntity<String>(encrypted_password,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoginData> getLoginData(@PathVariable int id) {

        try {
//			return ResponseEntity.ofNullable(employeeService.getEmployeeById(id)).orElseThrow(()-> new ResourceNotFoundException("transaction not found for this id :: " + id));
            LoginData test1  =  loginDataService.getLoginDataById(id);

            return ResponseEntity.ok(test1);


        }
        catch(ResourceNotFoundException e) {

            System.out.println(e.getMessage());
            return null;
        }

    }
    @GetMapping("/getAll")
    public ResponseEntity<List<LoginData>> getAllLoginData() {
        List<LoginData> loginData = loginDataService.getAllLoginData();
        return ResponseEntity.ok(loginData);
    }


}