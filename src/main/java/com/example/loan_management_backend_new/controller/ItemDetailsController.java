package com.example.loan_management_backend_new.controller;

import java.util.List;




import com.example.loan_management_backend_new.entities.AuthRequest;
//import com.example.loan_management_backend_new.config.SecurityConfig;
import com.example.loan_management_backend_new.exceptions.ResourceNotFoundException;
import com.example.loan_management_backend_new.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import com.example.loan_management_backend_new.entities.ItemDetails;
import com.example.loan_management_backend_new.services.ItemDetailsService;



import jakarta.validation.Valid;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/logindata")
public class ItemDetailsController {
    @Autowired
    private ItemDetailsService itemDetailsService;

	@PostMapping("/add")
	public ResponseEntity<ItemDetails> addItemDetails(@Valid @RequestBody ItemDetails itemDetails) {
		ItemDetails itemDetails1 = itemDetailsService.addItemDetails(itemDetails);
		return new ResponseEntity<ItemDetails>(itemDetails1,HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<ItemDetails>> getAllLoanItems() {
		List<ItemDetails> itemDetails = itemDetailsService.getAllItemDetails();
		return ResponseEntity.ok(itemDetails);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ItemDetails> updateItemDetails(@PathVariable int id, @RequestBody ItemDetails itemDetails){
		/*
		 * ItemDetails findItemDetails = itemDetailsService.getItemDetailsById(id);
		 * if(findItemDetails != null){ System.out.print(findItemDetails); } assert
		 * findItemDetails != null; findItemDetails.setItemId(itemDetails.getItemId());
		 * findItemDetails.setItemCategory(itemDetails.getItemCategory());
		 * findItemDetails.setItemValue(itemDetails.getItemValue());
		 * findItemDetails.setItemStatus(itemDetails.getItemStatus());
		 * findItemDetails.setItemStatus(itemDetails.getItemMake());
		 * 
		 * ItemDetails updatedItemDetails =
		 * itemDetailsService.addItemDetails(findItemDetails); return
		 * ResponseEntity.ok(updatedItemDetails);
		 */
		
			
			return itemDetailsService.updateItemDetails(id, itemDetails);
		

	}

	@DeleteMapping("/remove/{id}")
	public String deleteItemDetails(@PathVariable int id){
		ItemDetails findItemDetails = itemDetailsService.getItemDetailsById(id);
		itemDetailsService.removeItemDetails(findItemDetails);
		return "Item Details deleted";
	}
}