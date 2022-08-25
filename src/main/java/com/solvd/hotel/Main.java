package com.solvd.hotel;


import com.solvd.hotel.enums.RoomType;
import com.solvd.hotel.exceptions.AgeException;
import com.solvd.hotel.logic.BookingRoomService;
import com.solvd.hotel.logic.CheckIn;
import com.solvd.hotel.mainHotel.Partner;
import com.solvd.hotel.people.Employee;
import com.solvd.hotel.people.Guest;
import com.solvd.hotel.processes.BookingService;
import com.solvd.hotel.processes.CheckInService;
import com.solvd.hotel.processes.EmployeeService;
import com.solvd.hotel.processes.PartnerService;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

import com.solvd.hotel.exceptions.InvalidChoiceException;

import java.util.*;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    /*public static void main(String[] args) {

        final BookingRoomService roomService = new BookingRoomService();

        final Guest firstGuest = new Guest();
        final List<Guest> guests;
        guests = new ArrayList<>();
        guests.add(firstGuest);

        Booking booking = new Booking();





     */


       /* try {

            checkIn.checkAge();

        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        logger.info(checkIn.toString());

        Task1 stringTask = new Task1();
        stringTask.count();

        IRename ren = value -> StringUtils.reverse(value);
        IAddTime a = () -> IAddTime.FORMATTER.format(Calendar.getInstance().getTime());
        logger.info(ren.rename(firstGuest.getName()) + " " + a.addTime());

        HotelInfo hotelInfo = new HotelInfo();
        hotelInfo.setHotelName("UK = HOME");
        //logger.info(hotelInfo.getHotelName());
        String name = null;
        try {
            Field field = hotelInfo.getClass().getDeclaredField("hotelName");
            field.setAccessible(true);
            field.set(hotelInfo, (String) "after reflection");
            name = (String) field.get(hotelInfo);
            Method method = hotelInfo.getClass().getDeclaredMethod("getHotelName");
            method.setAccessible(true);
            logger.info(method.invoke(hotelInfo));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        logger.info(name);


        AdditionalService additionalService1 = new AdditionalService(true, false, "tidy up", true, "breakfast");
        AdditionalService additionalService2 = new AdditionalService(false, false, "beauty routine", true, "vegan menu");
        AdditionalService additionalService3 = new AdditionalService(true, true, "city guide", true, "three meals a day");
        List<AdditionalService> additionalService = new ArrayList<>();
        additionalService.add(additionalService1);
        additionalService.add(additionalService2);

        Employee employee1 = new Employee("Petro", "Ivanov", 23, "waiter", "+380999443766", 4520, 1252);
        Employee employee2 = new Employee("Ann", "Pysar", 21, "hostess", "+380999443767", 5000, 1253);
        ArrayList<Employee> employees = new ArrayList<Employee>();
        employees.add(employee1);
        employees.add(employee2);

        HashMap<Integer, String> bookingIdAndGuests = new HashMap<>();
        bookingIdAndGuests.put(25364, "Petro Ivanov");
        bookingIdAndGuests.put(55642, "Ann Pysar");
        logger.info(bookingIdAndGuests);


    }*/

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