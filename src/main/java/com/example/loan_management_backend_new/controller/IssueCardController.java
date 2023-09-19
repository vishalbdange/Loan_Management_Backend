package com.example.loan_management_backend_new.controller;

import com.example.loan_management_backend_new.entities.Employee;
import com.example.loan_management_backend_new.entities.IssueCard;
import com.example.loan_management_backend_new.entities.LoanItem;
import com.example.loan_management_backend_new.exceptions.ResourceNotFoundException;
import com.example.loan_management_backend_new.services.IssueCardService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/issuecard")
public class IssueCardController {
	@Autowired
	private IssueCardService issueCardService;
	
	@PostMapping("/add")
	public ResponseEntity<IssueCard> addIssueCard(@Valid @RequestBody IssueCard issueCard) {
		IssueCard issueCard1 = issueCardService.addIssueCard(issueCard);
		return new ResponseEntity<IssueCard>(issueCard1,HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<IssueCard> getIssueCard(@PathVariable int id) {

		try {
//			return ResponseEntity.ofNullable(employeeService.getEmployeeById(id)).orElseThrow(()-> new ResourceNotFoundException("transaction not found for this id :: " + id));
			IssueCard test  =  issueCardService.getIssueCardById(id);

			return ResponseEntity.ok(test);

		}
		catch(ResourceNotFoundException e) {

			System.out.println(e.getMessage());
			return null;
		}

	}
	@GetMapping("/getAll")
	public ResponseEntity<List<IssueCard>> getAllIssueCards() {
		List<IssueCard> issueCards = issueCardService.getAllIssueCards();
		return ResponseEntity.ok(issueCards);
	}


	@PutMapping("/update/{id}")
	public ResponseEntity<IssueCard> update_user(@PathVariable int id, @RequestBody IssueCard issueCard){
		IssueCard find_issueCard = issueCardService.getIssueCardById(id);
		if(find_issueCard != null){
			System.out.print(find_issueCard);
		}
		assert find_issueCard != null;
		find_issueCard.setIssue_id(issueCard.getIssue_id());
		find_issueCard.setEmployee_id(issueCard.getEmployee_id());
		find_issueCard.setItem_id(issueCard.getItem_id());
		find_issueCard.setReturn_date(issueCard.getReturn_date());
		find_issueCard.setIssue_date(issueCard.getIssue_date());


		IssueCard s = issueCardService.addIssueCard(find_issueCard);
//		Account updated_account = account_service_provider.getAccountByEmailId(find_user.getEmail()).orElseThrow(
//				()-> new ResourceNotFoundException("Product not found for this id :: " + id));
//		updated_account.setAccount_status(updated_user.getAccountStatus());
//	    Account updated_user_account = employeeService.save(updated_employee);
//		return ResponseEntity.ok(updated_user);
		return ResponseEntity.ok(s);
	}

	@DeleteMapping("/remove/{id}")
	public String delete_IssueCard(@PathVariable int id){
		IssueCard find_IssueCard = issueCardService.getIssueCardById(id);
		issueCardService.removeIssueCard(find_IssueCard);
		return "ISsue Card deleted";
	}


}