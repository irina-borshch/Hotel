package com.solvd.hotel.exceptions;

public class AgeException extends Exception {
    public AgeException() {

    }
    private int age;

    public AgeException(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
