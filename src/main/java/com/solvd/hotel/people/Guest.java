package com.solvd.hotel.people;

import com.solvd.hotel.interfaces.Cleanable;
import com.solvd.hotel.interfaces.IPersonInfo;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Guest extends Person implements IPersonInfo, Cleanable {
    private static final Logger logger = LogManager.getLogger(Guest.class);
    public int daysOfStay;
    private String phoneNumber;
    private boolean checkedIn;
    private String bookingOrder;

    public Guest() {

    }

    public Guest(String name, String lastName, int age, int daysOfStay, String phoneNumber, boolean checkedIn) {
        super(name, lastName, age);
        this.daysOfStay = daysOfStay;
        this.phoneNumber = phoneNumber;
        this.checkedIn = checkedIn;
    }

    public int getDaysOfStay() {
        return daysOfStay;
    }

    public void setDaysOfStay(int daysOfStay) {
        this.daysOfStay = daysOfStay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean getCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    @Override
    public void introduce() {
        logger.info("I'm " + getName() + " " + getLastName() + ". Am I checked in? " +
                (getCheckedIn() ? "Yes " : "No"));
    }

    @Override
    public void printBio() {
        logger.info(getName() + " " + getLastName());
    }

    @Override
    public void clean() {
        logger.info("I need a cleaning in my room.");
    }

    @Override
    public String getServiceType() {
        return getClass().getSimpleName();
    }

    /* @Override
     public String toString() {
         return getClass().getName() + "[name=" + getName() + ", lastName=" + getLastName() + ", age=" + getAge() +
                 ", daysOfStay=" + getDaysOfStay() + ", phoneNumber=" + getPhoneNumber() + ", checkedIn=" + getCheckedIn() + "]";
     }*/
    @Override
    public String toString() {
        return "Dear " + getName() + " " + getLastName() + "!. Nice to meet you in our hotel!";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName().hashCode(), getLastName().hashCode(),
                getDaysOfStay(), getPhoneNumber(), getCheckedIn());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guest guest = (Guest) o;
        return hashCode() == guest.hashCode();
    }

    public String getBookingOrder() {
        return bookingOrder;
    }

    public void setBookingOrder(String bookingOrder) {
        this.bookingOrder = bookingOrder;
    }


}


