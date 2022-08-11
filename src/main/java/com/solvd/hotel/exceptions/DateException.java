package com.solvd.hotel.exceptions;

public class DateException extends Exception {
    public DateException() {
        super("Invalid date. Choose date properly.");
    }

    public DateException(String message) {
        super(message);

    }
}
