package com.solvd.hotel.exceptions;

public class AgeException extends Exception {
    public AgeException() {
        super("You must be over 18 years old");

    }

    public AgeException(String message) {
        super(message);
    }

}
