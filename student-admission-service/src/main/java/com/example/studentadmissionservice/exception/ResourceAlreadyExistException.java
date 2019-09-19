package com.example.studentadmissionservice.exception;

public class ResourceAlreadyExistException extends Exception {
    public ResourceAlreadyExistException(String message) {
        super(message +" Already Exist ");
    }
}
