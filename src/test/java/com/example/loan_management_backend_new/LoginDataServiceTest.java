

package com.example.loan_management_backend_new;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.loan_management_backend_new.entities.LoginData;

import com.example.loan_management_backend_new.repositories.LoginDataRepository;
import com.example.loan_management_backend_new.services.LoginDataServiceImpl;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class LoginDataServiceTest {

    @InjectMocks
    private  LoginDataServiceImpl loginDataService;

    @Mock
    private  LoginDataRepository  loginDataRepository;

    @Test
    public void getAllIssueCardTest() {
    	LoginData LoginData1 = new  LoginData(123,"user","vishal");
    	LoginData LoginData2 = new  LoginData(223,"user","neeraj");
    	LoginData LoginData3 = new  LoginData(323,"admin","priyanka");

		List< LoginData> loginData = Arrays.asList(LoginData1, LoginData2, LoginData3);

		
        when( loginDataRepository.findAll()).thenReturn(loginData);

        List< LoginData> retrievedLoginData =  loginDataService.getAllLoginData();
        assertEquals(loginData.size(), retrievedLoginData.size());
        for (int i = 0; i < loginData.size(); i++) {
        	LoginData expectedLoginData =  loginData.get(i);
        	LoginData retrievedloginData = retrievedLoginData.get(i);
            assertEquals(expectedLoginData.getRoles(), retrievedloginData.getRoles());
            assertEquals(expectedLoginData.getPassword(), retrievedloginData.getPassword());
            assertEquals(expectedLoginData.getUsername(), retrievedloginData.getUsername());
           
        }
        
        verify(loginDataRepository, times(1)).findAll();
    }
    
  
    @Test
    public void addLoginDataTest() {
    	LoginData loginData = new LoginData(823,"admin","priya");
     	when(loginDataRepository.save(any(LoginData.class))).thenReturn(loginData);
        
     	LoginData savedLoginData = loginDataService.addLoginData(loginData);
        assertEquals(loginData.getRoles(), savedLoginData.getRoles());
        assertEquals(loginData.getPassword(), savedLoginData.getPassword());
        assertEquals(loginData.getUsername(),savedLoginData.getUsername());
       
        verify(loginDataRepository, times(1)).save(eq(loginData));
    }

    
}