package com.solvd.hotel.interfaces;

import com.solvd.hotel.invoice.Payment;

public interface IPaymentSuccess {
    boolean paymentSuccess(Payment payment);
    double getPrice();
}
