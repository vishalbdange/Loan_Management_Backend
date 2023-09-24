package com.example.loan_management_backend_new.services;

import java.util.List;


import com.example.loan_management_backend_new.entities.ItemDetails;


public interface ItemDetailsService {

    public ItemDetails addItemDetails(ItemDetails itemDetails);
    public ItemDetails getItemDetailsById(int id);
    public List<ItemDetails> getAllItemDetails();
    public void removeItemDetails(ItemDetails itemDetails);
}