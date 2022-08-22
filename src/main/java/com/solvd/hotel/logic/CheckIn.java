package com.solvd.hotel.logic;

import com.solvd.hotel.exceptions.AgeException;
import com.solvd.hotel.interfaces.Checkable;
import com.solvd.hotel.mainHotel.Room;
import com.solvd.hotel.enums.RoomType;
import com.solvd.hotel.people.Guest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;


public class CheckIn extends Reservation implements Checkable {
    private static final Logger logger = LogManager.getLogger(CheckIn.class);

    private RoomType type;
    private int roomNum;
    private Room selectedRoom;
    private boolean checkedIn = false;
    private int age;

    private BookingRoomService roomService;

    public CheckIn(List<Guest> guests, RoomType type, double price, BookingRoomService roomService) {
        super(guests, price);
        this.type = type;
        this.roomService = roomService;
    }


    public RoomType getRoomType() {
        return type;
    }

    public void setRoomType(RoomType type) {
        this.type = type;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
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
        return getClass().getName() + "[guest=" + getGuests() + ", roomType=" + getRoomType() + ", roomNum=" + getRoomNum()
                + ", price=" + getPrice() + ", checkedIn" + getCheckedIn() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGuests().hashCode(), getRoomType().hashCode(), getRoomNum(),
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

    public CheckIn checkAge() throws AgeException {
        logger.info("Please, indicate your age:");
        Scanner scan = new Scanner(System.in);
        try {
            this.age = scan.nextInt();
        } catch (RuntimeException e) {
            logger.info("Your input age is invalid. Please try again");
            checkAge();
        }
        if (age >= 18) {
            logger.info("Have a nice rest!");
        } else {
            logger.info("You can not be checked in. You must be of legal age or accompanied by an adult");
            throw new AgeException("Your age is " + age + ". That is why you can not be checked in. You must be over 18 years old");
        }
        this.selectedRoom = roomService.getFreeRoom(this.type);
        this.checkedIn = true;
        this.roomNum = selectedRoom.getRoomNumber();

        return this;
    }
}




