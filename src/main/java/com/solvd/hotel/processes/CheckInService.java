package com.solvd.hotel.processes;

import com.solvd.hotel.interfaces.Checkable;
import com.solvd.hotel.logic.BookingRoomService;
import com.solvd.hotel.logic.CheckIn;
import com.solvd.hotel.people.Guest;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.apache.commons.io.FileUtils.getFile;
import static org.apache.commons.io.FileUtils.readFileToString;

public class CheckInService implements Checkable {
    private static final Logger logger = LogManager.getLogger(CheckInService.class);
    private final BookingRoomService roomService;

    public CheckInService(BookingRoomService roomService) {
        this.roomService = roomService;
    }

    public CheckIn occupyRoom(Guest guest, CheckIn checkIn) {

        checkIn.setSelectedRoom(roomService.getFreeRoom(checkIn.getRoomType()));
        guest.setCheckedIn(true);


        return checkIn;
    }

    public boolean checkingIn() {

        Scanner scan = new Scanner(System.in);
        try {
            File guestData = getFile("src/main/resources/guest.txt");
            logger.info("Find information about booking order. Enter you booking ID.\n");
            String guest = FileUtils.readFileToString(guestData, Charsets.toCharset(StandardCharsets.UTF_8));
            String str = scan.nextLine();
            if (guest.contains(str)) {
                logger.info("You checked in successfully. We hope you will enjoy your stay in our hotel!");
                return true;
            } else {
                logger.info("Check in was not successful. Please create a booking.");
                return false;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean checkCheckIn(Guest guest) {
        if (guest.getCheckedIn()) {
            logger.info("Guest checked in successfully. We hope you will enjoy your stay in our hotel!");
            return true;
        } else {
            logger.info("Check in was not successful. Please make a booking on our website or contact us for reservation");
            return false;
        }
    }
}
