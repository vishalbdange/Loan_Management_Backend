package com.example.loan_management_backend_new.controller;

import java.util.List;


//import com.example.loan_management_backend_new.config.SecurityConfig;
import com.example.loan_management_backend_new.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.loan_management_backend_new.entities.ItemDetails;
import com.example.loan_management_backend_new.services.ItemDetailsService;



import jakarta.validation.Valid;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/itemdetails")
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
        ItemDetails findItemDetails = itemDetailsService.getItemDetailsById(id);
        if(findItemDetails != null){
            System.out.print(findItemDetails);
        }

        //assert findItemDetails != null;
        findItemDetails.setItemId(itemDetails.getItemId());
        findItemDetails.setItemCategory(itemDetails.getItemCategory());
        findItemDetails.setItemValue(itemDetails.getItemValue());
        findItemDetails.setItemStatus(itemDetails.getItemStatus());
        findItemDetails.setItemMake(itemDetails.getItemMake());
        findItemDetails.setItemDescription(itemDetails.getItemDescription());

        ItemDetails updatedItem = itemDetailsService.addItemDetails(findItemDetails);
        return ResponseEntity.ok(updatedItem);
    }




    @DeleteMapping("/remove/{id}")
    public String deleteItemDetails(@PathVariable int id){
        ItemDetails findItemDetails = itemDetailsService.getItemDetailsById(id);
        itemDetailsService.removeItemDetails(findItemDetails);
        return "Item Details deleted";
    }
}