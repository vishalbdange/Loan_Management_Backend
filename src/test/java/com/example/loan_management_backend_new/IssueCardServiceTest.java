
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

import com.example.loan_management_backend_new.entities.Employee;
import com.example.loan_management_backend_new.entities.IssueCard;
import com.example.loan_management_backend_new.repositories.IssueCardRepository;
import com.example.loan_management_backend_new.services.IssueCardServiceImpl;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class IssueCardServiceTest {

    @InjectMocks
    private  IssueCardServiceImpl issueCardService;

    @Mock
    private  IssueCardRepository  issueCardRepository;

    @Test
    public void getAllIssueCardTest() {
    	 IssueCard  issueCard1 = new  IssueCard(100, 101,102,LocalDate.of(2015, 12, 12),LocalDate.of(2014, 12, 12));
    	 IssueCard  issueCard2 = new  IssueCard(200, 201,202,LocalDate.of(2014, 12, 12),LocalDate.of(2015, 12, 12));
    	 IssueCard  issueCard3 = new  IssueCard(300, 301,302,LocalDate.of(2013, 12, 12),LocalDate.of(2016, 12, 12));

		List< IssueCard>  issueCard = Arrays.asList(issueCard1, issueCard2, issueCard3);

		
        when( issueCardRepository.findAll()).thenReturn(issueCard);

        List< IssueCard> retrievedissueCard =  issueCardService.getAllIssueCards();
        assertEquals(issueCard.size(), retrievedissueCard.size());
        for (int i = 0; i < issueCard.size(); i++) {
        	IssueCard expectedIssueCard =  issueCard.get(i);
        	IssueCard retrievedIssueCard = retrievedissueCard.get(i);
            assertEquals(expectedIssueCard.getIssue_id(), retrievedIssueCard.getIssue_id());
            assertEquals(expectedIssueCard.getItem_id(), retrievedIssueCard.getItem_id());
            assertEquals(expectedIssueCard.getEmployee_id(), retrievedIssueCard.getEmployee_id());
            assertEquals(expectedIssueCard.getReturn_date(),retrievedIssueCard.getReturn_date());
         // assertEquals(expectedemp.getSalary(), retrievedemp.getSalary());
            assertEquals(expectedIssueCard.getIssue_date(),retrievedIssueCard.getIssue_date());

            
            
        }
        
        verify(issueCardRepository, times(1)).findAll();
    }
    
    @Test
    public void getByIdTest() {
        int issueCardId = 4000;
        IssueCard  issueCard = new  IssueCard(4000, 401,402,LocalDate.of(2015, 12, 12),LocalDate.of(2014, 12, 12));
   	  
        when(issueCardRepository.findById(issueCardId)).thenReturn(Optional.of(issueCard));

        IssueCard retrievedIssueCard = issueCardService.getIssueCardById(issueCardId);  
        assertEquals(issueCard.getIssue_id(), retrievedIssueCard.getIssue_id());
        assertEquals(issueCard.getItem_id(), retrievedIssueCard.getItem_id());
        assertEquals(issueCard.getEmployee_id(), retrievedIssueCard.getEmployee_id());
        assertEquals(issueCard.getReturn_date(),retrievedIssueCard.getReturn_date());
        assertEquals(issueCard.getIssue_date(),retrievedIssueCard.getIssue_date());

    verify(issueCardRepository, times(1)).findById(issueCardId);
    }
    @Test
    public void removeIssueCardTest() {
    	IssueCard issueCard = new IssueCard(600, 601,702,LocalDate.of(2015, 12, 12),LocalDate.of(2014, 12, 12));
     	  
    	issueCardService.removeIssueCard(issueCard);;
        verify(issueCardRepository, times(1)).delete(issueCard);
    }
    @Test
    public void addIssueCardTest() {
    	IssueCard issueCard = new IssueCard(800, 801,802,LocalDate.of(2015, 12, 12),LocalDate.of(2014, 12, 12));
     	when(issueCardRepository.save(any(IssueCard.class))).thenReturn(issueCard);
        
     	IssueCard savedIssueCard = issueCardService.addIssueCard(issueCard);
        assertNotNull(savedIssueCard);
        assertEquals(issueCard.getIssue_id(), savedIssueCard.getIssue_id());
        assertEquals(issueCard.getItem_id(), savedIssueCard.getItem_id());
        assertEquals(issueCard.getEmployee_id(),savedIssueCard.getEmployee_id());
        assertEquals(issueCard.getReturn_date(),savedIssueCard.getReturn_date());
        assertEquals(issueCard.getIssue_date(),savedIssueCard.getIssue_date());

        verify(issueCardRepository, times(1)).save(eq(issueCard));
    }

    
}