package com.solvd.hotel.processes;

import com.solvd.hotel.interfaces.Checkable;
import com.solvd.hotel.logic.BookingRoomService;
import com.solvd.hotel.logic.CheckIn;
import com.solvd.hotel.people.Guest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CheckInService implements Checkable {
    private static final Logger logger = LogManager.getLogger(CheckInService.class);
    private final BookingRoomService roomService;

    public CheckInService(BookingRoomService roomService) {
        this.roomService = roomService;
    }

    public CheckIn occupyRoom(Guest guest, CheckIn checkIn)  {

        checkIn.setSelectedRoom(roomService.getFreeRoom(checkIn.getRoomType()));
        guest.setCheckedIn(true);



        return checkIn;
    }

    @Override
    public boolean checkCheckIn(Guest guest) {
        if (guest.getCheckedIn()) {
            logger.info("Guest checked in successfully. We hope you will enjoy your stay in our hotel!");
            return true;
        } else {
            logger.info("Check in was not successful. Please make a reservation on our website or contact us for reservation");
            return false;
        }
    }
}
