package com.MyProject.ProjectOne.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String messege) {
        super(messege);
    }
}
