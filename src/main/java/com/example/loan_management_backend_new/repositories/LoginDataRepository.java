package com.example.loan_management_backend_new.repositories;
import com.example.loan_management_backend_new.entities.LoginData;
import com.example.loan_management_backend_new.entities.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginDataRepository  extends JpaRepository<LoginData, Integer> {
    LoginData findByUsername(int username);
}
