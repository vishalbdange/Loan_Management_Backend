

package com.example.loan_management_backend_new.services;


import java.util.List;

import com.example.loan_management_backend_new.entities.LoginData;


import com.example.loan_management_backend_new.repositories.LoginDataRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Getter
@Setter
@Service
public class LoginDataServiceImpl implements LoginDataService {
    @Autowired
    private LoginDataRepository loginDataRepository;


    public void setLoginDataRepository(LoginDataRepository loginDataRepository) {
        this.loginDataRepository =loginDataRepository;
    }


    @Override
    public LoginData addLoginData(LoginData login_data) {
        // TODO Auto-generated method stub
        return loginDataRepository.save(login_data);

    }

    @Override
    public LoginData getLoginDataById(int id) {
        // TODO Auto-generated method stub
        return loginDataRepository.findById(id).orElse(null);
    }

    @Override
    public List<LoginData> getAllLoginData() {
        // TODO Auto-generated method stub
        return  loginDataRepository.findAll();
    }

}
