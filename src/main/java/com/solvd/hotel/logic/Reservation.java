package com.solvd.hotel.logic;

import com.solvd.hotel.people.Guest;

import java.util.List;
import java.util.Objects;


public abstract class Reservation {
    private List<Guest> guests;
    private double price;

    public Reservation() {

    }

    public Reservation(List<Guest> guests, double price) {
        this.guests = guests;
        this.price = price;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[guest=" + getGuests() + ", price=" + getPrice() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGuests().hashCode(), getPrice());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation reservation = (Reservation) o;

        return hashCode() == reservation.hashCode();
    }
}
