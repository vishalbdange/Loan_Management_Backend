package com.example.loan_management_backend_new.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    public ResourceNotFoundException(String message) {
        super(message);
    }

}