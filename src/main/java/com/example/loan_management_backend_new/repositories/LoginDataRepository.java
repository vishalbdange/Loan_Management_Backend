package com.example.loan_management_backend_new.repositories;
import com.example.loan_management_backend_new.entities.LoginData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginDataRepository  extends JpaRepository<LoginData, Integer> {
    LoginData findByUsername(Integer username);
}
