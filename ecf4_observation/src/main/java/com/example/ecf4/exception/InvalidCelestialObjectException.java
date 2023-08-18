package com.example.ecf4.exception;

public class InvalidCelestialObjectException extends Exception{
    public InvalidCelestialObjectException() {
        super("Invalid celestial object name");
    }
}
