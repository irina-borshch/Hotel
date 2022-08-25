package com.solvd.hotel;


import com.solvd.hotel.enums.RoomType;
import com.solvd.hotel.exceptions.AgeException;
import com.solvd.hotel.logic.BookingRoomService;
import com.solvd.hotel.logic.CheckIn;
import com.solvd.hotel.mainHotel.Partner;
import com.solvd.hotel.people.Employee;
import com.solvd.hotel.people.Guest;
import com.solvd.hotel.processes.*;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;


import java.util.*;


public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        final BookingRoomService roomService = new BookingRoomService();
        final BookingService bookingService = new BookingService();
        final CheckInService checkInService = new CheckInService(roomService);
        final PartnerService partnerService = new PartnerService();
        final EmployeeService employeeService = new EmployeeService();
        final File guestFile = new File("src/main/resources/guest.txt");
        final File partnerFile = new File("src/main/resources/partner.txt");
        final File employeeFile = new File("src/main/resources/employee.txt");
        final List<String> guestData = new ArrayList<>();
        final List<String> partnerData = new ArrayList<>();
        final List<String> employeeData = new ArrayList<>();
        final Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            logger.info("Welcome! We are pleased to welcome you to our boutique hotel UK = HOME. Choose your next steps:" + '\n' +
                    "1) Book a room." + '\n' +
                    "2) Already have a booking order. Want to check in." + '\n' +
                    "3) Want to check out. May I have the bill?" + '\n' +
                    "4) Become a partner of our hotel." + '\n' +
                    "5) Want to become a part of our team." + '\n' +
                    "0) Exit" + '\n' + '\n' +
                    "Make your choice:");
            choice = scanner.nextInt();

            try {

                switch (choice) {
                    case 1:

                        CheckIn checkIn = new CheckIn(chooseRoom());
                        Guest guest = bookingService.fillGuestInfo();
                        checkIn = checkInService.occupyRoom(guest, checkIn);
                        guestData.add("First name: " + guest.getName());
                        guestData.add("Last name: " + guest.getLastName());
                        guestData.add("Age: " + guest.getAge());
                        guestData.add("Preferred room: " + checkIn.getRoomType());
                        guestData.add("Amount days of stay: " + guest.getDaysOfStay());
                        guestData.add("Booking order: " + guest.getBookingOrder());
                        FileUtils.writeLines(guestFile, guestData, true);
                        break;
                    case 2:
                        checkInService.checkingIn();
                        break;
                    case 3:
                        CheckOutService.payBill();
                        break;
                    case 4:
                        Partner partner = partnerService.fillPartnerInfo();
                        partnerData.add("First name: " + partner.getPartnerName());
                        partnerData.add("Last name: " + partner.getPartnerLastName());
                        partnerData.add("Phone number: " + partner.getPhoneNumber());
                        FileUtils.writeLines(partnerFile, partnerData, true);
                        break;
                    case 5:
                        Employee employee = employeeService.fillEmployeeInfo();
                        employeeData.add("First name: " + employee.getName());
                        employeeData.add("Last name: " + employee.getLastName());
                        employeeData.add("Phone number: " + employee.getPhoneNumber());
                        FileUtils.writeLines(employeeFile, employeeData, true);
                        break;
                    case 0:
                        logger.info("Exit from the Hotel. Have a nice day!");
                        return;
                    default:
                        logger.info("Invalid data entry. Choose correct option.");
                }
            } catch (IOException e) {
                logger.error(e);
            } catch (AgeException e) {
                throw new RuntimeException(e);
            }

        } while (true);
    }

    private static RoomType chooseRoom() {
        logger.info("Choose room which you want:\n" +
                "1) SINGLE\n" +
                "2) DOUBLE\n" +
                "3) TRIPLE\n" +
                "4) QUAD\n" +
                "5) QUEEN\n" +
                "6) ECONOM\n" +
                "7) PENTHOUSE\n");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        RoomType type;
        switch (choice) {
            case 1:
                type = RoomType.SINGLE;
                break;
            case 2:
                type = RoomType.DOUBLE;
                break;
            case 3:
                type = RoomType.TRIPLE;
                break;
            case 4:
                type = RoomType.QUAD;
                break;
            case 5:
                type = RoomType.QUEEN;
                break;
            case 6:
                type = RoomType.ECONOM;
                break;
            case 7:
                type = RoomType.PENTHOUSE;
                break;
            case 8:
                type = null;
                break;
            default:
                throw new RuntimeException("Invalid room type");
        }
        return type;

    }

}