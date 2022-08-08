package com.solvd.hotel.people;

import com.solvd.hotel.interfaces.Cleanable;
import com.solvd.hotel.interfaces.IPersonInfo;

import java.util.Objects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Guest extends Person implements IPersonInfo, Cleanable {
    private static final Logger logger = LogManager.getLogger(Guest.class);
    private int daysOfStay;
    private int phoneNumber;
    private boolean checkedIn;

    public Guest() {

    }

    public Guest(String name, String lastName, int daysOfStay, int phoneNumber, boolean checkedIn) {
        super(name, lastName);
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean getCheckedIn() {
        return checkedIn;
    }

    public void setChecked(boolean checkedIn) {
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

    @Override
    public String toString() {
        return getClass().getName() + "[name=" + getName() +", lastName=" + getLastName() + ", daysOfStay=" + getDaysOfStay()
                + ", phoneNumber=" + getPhoneNumber() + ", checkedIn=" + getCheckedIn() +"]";
    }

    @Override
    public int hashCode () {
        return Objects.hash(getName().hashCode(), getLastName().hashCode(), getDaysOfStay(), getPhoneNumber(), getCheckedIn());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guest guest = (Guest) o;
        return hashCode() == guest.hashCode();
    }
}


