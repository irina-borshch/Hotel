package com.solvd.hotel.logic;

import com.solvd.hotel.exceptions.DateException;
import com.solvd.hotel.invoice.Payment;
import com.solvd.hotel.people.Guest;

import java.util.List;
import java.util.Objects;

public class BookingOrder extends Reservation {
    private boolean booking;
    private Payment payment;

    public BookingOrder(boolean booking, List<Guest> guests, double price, Payment payment) {
        super(guests, price);

        this.booking = booking;
        this.payment = payment;
    }

    public BookingOrder(Object bookingOrder) {
    }


    public boolean getBooking() {
        return booking;
    }

    public void setBooking(boolean booking) {
        this.booking = booking;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[booking=" + getBooking() + ", guest=" + getGuests() + ", price=" + getPrice() + ", payment=" + getPayment() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBooking(), getGuests().hashCode(), getPrice(), getPayment().hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingOrder bookingOrder = (BookingOrder) o;
        return hashCode() == bookingOrder.hashCode();
    }

}
