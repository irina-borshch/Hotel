package com.solvd.hotel.logic;

import com.solvd.hotel.people.Guest;

import java.util.Calendar;
import java.util.Objects;


public abstract class Reservation {
    private Guest[] guest;
    private Calendar date;
    private double price;

    public Reservation(){

    }
    public Reservation(Guest[] guest, Calendar date, double price) {
        this.guest = guest;
        this.date = date;
        this.price = price;
    }
    public Guest[] getGuest() {
        return guest;
    }

    public void setGuest(Guest[] guest) {
        this.guest = guest;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[guest=" + getGuest() +", date=" + getDate() + ", price=" + getPrice() +"]";
    }

    @Override
    public int hashCode () {
        return Objects.hash(getGuest().hashCode(), getDate().hashCode(), getPrice());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation reservation = (Reservation) o;

        return hashCode() == reservation.hashCode();
    }
}
