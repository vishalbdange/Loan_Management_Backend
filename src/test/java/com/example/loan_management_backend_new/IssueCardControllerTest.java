package com.example.loan_management_backend_new;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.example.loan_management_backend_new.controller.IssueCardController;
import com.example.loan_management_backend_new.entities.Employee;
import com.example.loan_management_backend_new.entities.IssueCard;
import com.example.loan_management_backend_new.services.IssueCardServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class IssueCardControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	private IssueCardController issueCardController;

	@Mock
	private IssueCardServiceImpl issueCardServiceProvider;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(issueCardController).build();
	}
	/*
	 * @Test public void getAllIssueCardTest() throws Exception { IssueCard
	 * issueCard1 = new IssueCard(500, 501,502,LocalDate.of(2015, 12,
	 * 12),LocalDate.of(2014, 12, 12)); IssueCard issueCard2 = new IssueCard(600,
	 * 601,602,LocalDate.of(2014, 12, 12),LocalDate.of(2015, 12, 12)); IssueCard
	 * issueCard3 = new IssueCard(700, 701,702,LocalDate.of(2013, 12,
	 * 12),LocalDate.of(2016, 12, 12));
	 * 
	 * List< IssueCard> issueCard = Arrays.asList(issueCard1, issueCard2,
	 * issueCard3);
	 * 
	 * when(issueCardServiceProvider.getAllIssueCards()).thenReturn(issueCard);
	 * 
	 * mockMvc.perform(get("/api/issuecard/getAll")).andExpect(status().isOk())
	 * .andExpect(jsonPath("$.length()", is(issueCard.size())))
	 * .andExpect(jsonPath("$[0].Issue_id", is(issueCard.get(0).getIssue_id())))
	 * .andExpect(jsonPath("$[1].Issue_id", is(issueCard.get(1).getIssue_date())))
	 * .andExpect(jsonPath("$[2].Issue_id", is(issueCard.get(2).getIssue_date())));
	 * 
	 * verify(issueCardServiceProvider, times(1)).getAllIssueCards(); }
	 */
	
	@Test
	public void deleteIssueCardTest() throws Exception {
		IssueCard todeleteissueCard = new IssueCard(900, 901,902,LocalDate.of(2015, 12, 12),LocalDate.of(2014, 12, 12));
		int issueCardId = 900;

		when(issueCardServiceProvider.getIssueCardById(issueCardId)).thenReturn(todeleteissueCard);

		mockMvc.perform(delete("/api/issuecard/remove/{id}", issueCardId)).andExpect(status().isOk());

		verify(issueCardServiceProvider, times(1)).removeIssueCard(todeleteissueCard);
	}

	
}