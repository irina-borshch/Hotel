package com.solvd.hotel.exceptions;

public class InvalidPaymentException extends Exception{
    /*public InvalidTransactionException() {

    }*/
    public InvalidPaymentException() {};
    public InvalidPaymentException(String message) {
        super(message);
    }

}


