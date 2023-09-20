


package com.example.loan_management_backend_new.services;

import java.util.List;

import com.example.loan_management_backend_new.entities.LoginData;

public interface LoginDataService {

    public LoginData addLoginData(LoginData login_data);
    public LoginData getLoginDataById(int id);
    public List<LoginData> getAllLoginData();

}
