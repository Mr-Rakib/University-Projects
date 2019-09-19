package com.example.studentadmissionservice.exception;

public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException(String s) {
        super(s+" Not Found !");
    }
}
