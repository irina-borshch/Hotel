package com.solvd.hotel.enums;

public enum Discount {
    GUEST(0),
    REGULAR_GUEST(10),
    PARTNER(20),
    EMPLOYEE(15);

    private final double discount;

    Discount(int discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }
}
