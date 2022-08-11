package com.solvd.hotel.logic;

import com.solvd.hotel.exceptions.DateException;
import com.solvd.hotel.interfaces.IReceptionCall;
import com.solvd.hotel.mainHotel.RoomType;
import com.solvd.hotel.people.Guest;
import com.solvd.hotel.logic.BookingOrder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Booking extends Reservation implements IReceptionCall {
    private static final Logger logger = LogManager.getLogger(Booking.class);


    private int bookingId;
    private RoomType type;
    private int numberOfGuests;
    private int numberOfDays;
    private int age;
    private boolean booked = false;


    public Booking(int bookingId, RoomType type, List<Guest> guests, int numberOfGuests,
                   int numberOfDays, double price, int age) {
        super(guests, price);
        this.bookingId = bookingId;
        this.type = type;
        this.numberOfGuests = numberOfGuests;
        this.numberOfDays = numberOfDays;
        this.age = age;


    }

    public Booking() {

    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
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

    public boolean getBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }


    @Override
    public String toString() {
        return getClass().getName() + "[guest=" + getGuests() + ", bookingId=" + getBookingId()
                + ", type=" + getType() + ", numberOfGuests=" + getNumberOfGuests() + ", numberOfDays=" + getNumberOfGuests()
                + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGuests().hashCode(), getBookingId(), getType().hashCode(),
                getNumberOfGuests(), getNumberOfDays());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return hashCode() == booking.hashCode();
    }

    public void checkDate() throws DateException {
        logger.info("Please enter booking date");
        Scanner scan = new Scanner(System.in);
        int date = scan.nextInt();
        LocalDate dateNow = LocalDate.now();
        LocalDate guestDate = LocalDate.of(2022, 8, 10);
        if (guestDate.isBefore(dateNow)) {
            try {
                throw new DateException();
            } catch (DateException e) {
                logger.info("Your date is invalid.");
                checkDate();
            }
            if (guestDate.isAfter(dateNow)) {
                logger.info("You've created a booking. Thank you for choosing us!");
            } else {
                logger.info("You can not be able make a booking. Try again.");
                throw new DateException("Your selected date is not valid.");

            }

        }
    }
}
