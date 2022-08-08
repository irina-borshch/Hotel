package com.solvd.hotel.logic;

import com.solvd.hotel.exceptions.Check;
import com.solvd.hotel.exceptions.DateException;
import com.solvd.hotel.invoice.Payment;
import com.solvd.hotel.people.Guest;

import java.util.Calendar;
import java.util.Objects;
public class BookingOrder extends Reservation{
    private boolean booking;
    private Payment payment;

    public BookingOrder(boolean booking, Guest[] guest, Calendar date, double price, Payment payment) throws DateException {
        super(guest, date, price);
        Calendar calendar = Calendar.getInstance();
        if (date.after(calendar)) {
            throw new DateException();
        }
        this.booking = booking;
        this.payment = payment;
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
        return getClass().getName() + "[booking=" + getBooking() + ", guest=" + getGuest() + ", date=" + getDate() +
                ", price=" + getPrice() + ", payment=" + getPayment() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBooking(), getGuest().hashCode(), getDate().hashCode(), getPrice(), getPayment().hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingOrder bookingOrder = (BookingOrder) o;
        return hashCode() == bookingOrder.hashCode();
    }
}
