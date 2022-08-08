package com.solvd.hotel.logic;

import com.solvd.hotel.interfaces.Checkable;
import com.solvd.hotel.people.Guest;
import com.solvd.hotel.mainHotel.roomType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class CheckIn extends Reservation implements Checkable {
    private static final Logger logger = LogManager.getLogger(CheckIn.class);

    private roomType type;
    private int roomNum;
    private boolean checkedIn;

    public CheckIn(Guest[] guest, roomType type, int roomNum, Calendar date, double price, boolean checkedIn) {
        super(guest, date, price);

        this.type = type;
        this.roomNum = roomNum;
        this.checkedIn = checkedIn;
    }
    public roomType getRoomType() {
        return type;
    }

    public void setRoomType (roomType type) {
        this.type = type;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum (int roomNum) {
        this.roomNum = roomNum;
    }

    public boolean getCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[guest=" + getGuest() + ", roomType=" + getRoomType() + ", roomNum=" + getRoomNum()
                + ", date=" + getDate() + ", price=" + getPrice() + ", checkedIn" + getCheckedIn() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGuest().hashCode(), getRoomType().hashCode(), getRoomNum(), getDate().hashCode(),
                getPrice(), getCheckedIn());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckIn checkIn = (CheckIn) o;
        return hashCode() == checkIn.hashCode();
    }

    @Override
    public boolean checkIn(CheckIn checkIn) {
        if (checkIn.checkedIn) {
            logger.info("Guest checked in successfully. We hope you will enjoy your stay in our hotel!");
            return true;
        } else {
            logger.info("Check in was not successful. Please make a reservation on our website or contact us for reservation");
            return false;
        }
    }
    @Override
    public void approveNumberOfGuests() {
        logger.info("Please check the amount of guests. Thanks!");
    }
    @Override
    public void checkPersonalInfo() {
        logger.info("Please check  personal information. Thanks!");
    }
}

