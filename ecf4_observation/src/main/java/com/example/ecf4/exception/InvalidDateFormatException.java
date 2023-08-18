package com.example.ecf4.exception;

public class InvalidDateFormatException extends Exception{

    public InvalidDateFormatException() {
        super("Enter a valid date format (yyyy-MM-dd");
    }
}
