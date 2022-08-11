package com.solvd.hotel.exceptions;

public class InvalidPaymentException extends Exception {

    public InvalidPaymentException() {
        super("Your payment was failed. Please try again.");
    }

    public InvalidPaymentException(String message) {
        super(message);
    }

}


