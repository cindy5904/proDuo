package org.example.authentificationservice.exception;

public class UserAlreadyExistException extends Exception{
    public UserAlreadyExistException() {
        super("User already exists");
    }
}
