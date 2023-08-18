package com.example.ecf4.exception;

public class InvalidIdException extends Exception{
    public InvalidIdException() {
        super("Enter a valid id");
    }
}
