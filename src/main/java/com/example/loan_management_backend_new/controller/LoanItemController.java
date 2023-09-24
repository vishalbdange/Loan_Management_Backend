package com.example.loan_management_backend_new.controller;

import java.util.List;

import com.example.loan_management_backend_new.entities.Employee;
import com.example.loan_management_backend_new.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import com.example.loan_management_backend_new.entities.LoanItem;
import com.example.loan_management_backend_new.services.LoanItemService;

import jakarta.validation.Valid;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/loanitem")
public class LoanItemController {
	@Autowired
	private LoanItemService loanItemService;
	
	@PostMapping("/add")
	public ResponseEntity<LoanItem> addLoanItem(@Valid @RequestBody LoanItem loan_item) {
		LoanItem loanitem1 = loanItemService.addLoanItem(loan_item);
		return new ResponseEntity<LoanItem>(loanitem1,HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<LoanItem>> getAllLoanItems() {
		List<LoanItem> loanItems = loanItemService.getAllLoanItems();
		return ResponseEntity.ok(loanItems);
	}

	@GetMapping("/{id}")
	public ResponseEntity<List<LoanItem>> getLoanItem(@PathVariable int id) {

		try {
//			return ResponseEntity.ofNullable(employeeService.getEmployeeById(id)).orElseThrow(()-> new ResourceNotFoundException("transaction not found for this id :: " + id));
			List<LoanItem> test  =  loanItemService.getLoanItemsByEmployeeId(id);

			return ResponseEntity.ok(test);

		}
		catch(ResourceNotFoundException e) {

			System.out.println(e.getMessage());
			return null;
		}

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<LoanItem> update_user(@PathVariable int id, @RequestBody LoanItem loanItem){
		LoanItem find_loanItem = loanItemService.getLoanItemById(id);
		if(find_loanItem != null){
			System.out.print(find_loanItem);
		}
        assert find_loanItem != null;
        find_loanItem.setEmployeeId(loanItem.getEmployeeId());
		find_loanItem.setItemDescription(loanItem.getItemDescription());
		find_loanItem.setItemCategory(loanItem.getItemCategory());
		find_loanItem.setItemValue(loanItem.getItemValue());
		find_loanItem.setLoanStatus(loanItem.getLoanStatus());
		find_loanItem.setLoanId(loanItem.getLoanId());
		find_loanItem.setLoanType(loanItem.getLoanType());
		find_loanItem.setItemDuration(loanItem.getItemDuration());

		LoanItem updated_loanItem = loanItemService.addLoanItem(find_loanItem);
//		Account updated_account = account_service_provider.getAccountByEmailId(find_user.getEmail()).orElseThrow(
//				()-> new ResourceNotFoundException("Product not found for this id :: " + id));
//		updated_account.setAccount_status(updated_user.getAccountStatus());
//	    Account updated_user_account = employeeService.save(updated_employee);
//		return ResponseEntity.ok(updated_user);
		return ResponseEntity.ok(updated_loanItem);
	}

	@DeleteMapping("/remove/{id}")
	public String delete_LoanItem(@PathVariable int id){
		LoanItem find_LoanItem = loanItemService.getLoanItemById(id);
		loanItemService.removeLoanItem(find_LoanItem);
		return "Loan item deleted";
	}
}