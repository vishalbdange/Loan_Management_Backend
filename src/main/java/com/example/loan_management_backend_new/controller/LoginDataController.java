package com.example.loan_management_backend_new.controller;

import java.util.*;

import com.example.loan_management_backend_new.entities.*;
import com.example.loan_management_backend_new.config.SecurityConfig;
import com.example.loan_management_backend_new.exceptions.ResourceNotFoundException;
import com.example.loan_management_backend_new.repositories.LoginDataRepository;
import com.example.loan_management_backend_new.repositories.UserInfoRepository;
import com.example.loan_management_backend_new.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.loan_management_backend_new.controller.UserController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    private LoginDataRepository loginDataRepository;

    @Autowired
    private UserInfoService userinfoservice;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SecurityConfig security;

    @Autowired
    private UserInfoRepository userinforepo;

    @PostMapping("/add")
//    public ResponseEntity<UserDetails> addLoginData(@Valid @RequestBody LoginData loginData) {
    public ResponseEntity<String> addLoginData(@Valid @RequestBody LoginData loginData) {
        LoginData loginData1 = loginDataRepository.findByUsername(loginData.getUsername());

        UserDetails user_details = userinfoservice.loadUserByUsername(String.valueOf(loginData.getUsername()));

        String isPasswordMatched = String.valueOf(security.passwordEncoder().matches(loginData.getPassword(),user_details.getPassword()));
//        HashMap<String,ResponseEntity<String>> tokenUserRoleDetails = new HashMap<String,ResponseEntity<String>>();

        if(isPasswordMatched.equals("true")){

//            System.out.println("Hiiiiii");
//            tokenUserRoleDetails.put(loginData1.getRoles() , new ResponseEntity<String> (jwtService.generateToken(String.valueOf(loginData.getUsername())),HttpStatus.CREATED));
//             return tokenUserRoleDetails;
//            loginCred.add(loginData1.getRoles());
////            loginCred.add()
        return new ResponseEntity<String> (jwtService.generateToken(String.valueOf(loginData.getUsername())),HttpStatus.CREATED);

        }else{
//            tokenUserRoleDetails.put("InvalidUser" , new ResponseEntity<String>("Authentication Failed",HttpStatus.CREATED));
//            return tokenUserRoleDetails;
            return new ResponseEntity<String>("Authentication Failed",HttpStatus.CREATED);
        }


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

    @PutMapping("/forgotpassword/{id}")
    public ResponseEntity<LoginData> updatePassword(@PathVariable int id, @RequestBody LoginData user){
        LoginData find_user = loginDataService.getLoginDataById(id);
//        UserInfo find_userInfo ;
//        find_userInfo  = userinforepo.findByName(String.valueOf(user.getUsername()));

        if(find_user != null){
            System.out.print(find_user);
        }

        assert find_user != null;

//        if(find_userInfo != null){
//            System.out.print(find_userInfo);
//        }
//
//        assert find_userInfo != null;


        String password = security.passwordEncoder().encode(user.getPassword());
//
//        find_userInfo.setUsername(String.valueOf(user.getUsername()));
//        find_userInfo.setPassword(password);
//        find_userInfo.setEmail(find_userInfo.getEmail());
//        find_userInfo.setRoles(find_userInfo.getRoles());

        find_user.setUsername(find_user.getUsername());
        find_user.setPassword(password);
        find_user.setRoles(find_user.getRoles());

//        find_userInfo.setPassword(find_userInfo.getUsername());


        LoginData updated_user = loginDataService.addLoginData(find_user);
//        userinfoservice.addUser(find_userInfo);

        return ResponseEntity.ok(updated_user);
    }


}