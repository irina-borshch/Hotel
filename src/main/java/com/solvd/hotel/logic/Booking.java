package com.solvd.hotel.logic;

import com.solvd.hotel.exceptions.AgeException;
import com.solvd.hotel.exceptions.Check;
import com.solvd.hotel.interfaces.IReceptionCall;
import com.solvd.hotel.people.Guest;
import com.solvd.hotel.mainHotel.roomType;

import java.util.Objects;
import java.util.Calendar;

public class Booking extends Reservation implements IReceptionCall {

    private int bookingId;
    private roomType type;
    private int numberOfGuests;
    private int numberOfDays;
    private int age;

    Check c;

    {
        new Check();
    }

    public Booking(int bookingId, roomType type, Guest[] guest, int numberOfGuests,
                   Calendar date, int numberOfDays, double price, int age) {
        super(guest, date, price);
        this.bookingId = bookingId;
        this.type = type;
        this.numberOfGuests = numberOfGuests;
        this.numberOfDays = numberOfDays;
        this.age = age;
        try {
            c.ageCheck(age);
        } catch (AgeException e) {
            this.age = age;
        }
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public roomType getType() {
        return type;
    }

    public void setType(roomType type) {
        this.type = type;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfGuests) {
        this.numberOfDays = numberOfGuests;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[guest=" + getGuest() + ", date=" + getDate() + ", bookingId=" + getBookingId()
                + ", type=" + getType() + ", numberOfGuests=" + getNumberOfGuests() + ", numberOfDays=" + getNumberOfGuests()
                + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGuest().hashCode(), getDate().hashCode(), getBookingId(), getType().hashCode(),
                getNumberOfGuests(), getNumberOfDays());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return hashCode() == booking.hashCode();
    }
}

