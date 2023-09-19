//package com.example.loan_management_backend_new.services;
//import com.example.loan_management_backend_new.entities.LoginData;
//import com.example.loan_management_backend_new.repositories.LoginDataRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class LoginDataService implements UserDetailsService {
//
//    @Autowired
//    private LoginDataRepository repository;
//
//    @Autowired
//    private PasswordEncoder encoder;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        Optional<LoginData> userDetail = repository.findByEmployee_id(username);
//
//        // Converting userDetail to UserDetails
//        return userDetail.map(UserInfoDetails::new)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
//    }
//
//    public String addUser(UserInfo userInfo) {
//        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
//        repository.save(userInfo);
//        return "User Added Successfully";
//    }
//
//
//}
//
//
//
//
////package com.example.loan_management_backend_new.services;
////
////import java.util.List;
////
////import com.example.loan_management_backend_new.entities.LoginData;
////
////public interface LoginDataService {
////
////    public LoginData addLoginData(LoginData login_data);
////    public LoginData getLoginDataById(int id);
////    public List<LoginData> getAllLoginData();
////
////}
