package com.solvd.hotel;


import com.solvd.hotel.interfaces.functional.IAddTime;
import com.solvd.hotel.interfaces.functional.IRename;
import com.solvd.hotel.invoice.AdditionalService;
import com.solvd.hotel.logic.Booking;
import com.solvd.hotel.logic.BookingRoomService;
import com.solvd.hotel.logic.CheckIn;
import com.solvd.hotel.enums.RoomType;
import com.solvd.hotel.people.Employee;
import com.solvd.hotel.people.Guest;
import com.solvd.hotel.taskUtils.Task1;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        final BookingRoomService roomService = new BookingRoomService();

        final Guest firstGuest = new Guest();
        final List<Guest> guests;
        guests = new ArrayList<>();
        guests.add(firstGuest);

        Booking booking = new Booking();

        CheckIn checkIn = new CheckIn(guests, RoomType.ECONOM, 100, roomService);
        CheckIn secondCheckIn = new CheckIn(guests, RoomType.ECONOM, 200, roomService);

        List<CheckIn> checkIns = Arrays.asList(checkIn, secondCheckIn);

        try {
            for (CheckIn currentCheckIn : checkIns) {
                currentCheckIn.checkAge();
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        logger.info(checkIn.toString());

        Task1 stringTask = new Task1();
        stringTask.count();

        IRename ren = value -> StringUtils.reverse(value);
        IAddTime a = () -> IAddTime.FORMATTER.format(Calendar.getInstance().getTime());
        logger.info(ren.rename(firstGuest.getName()) + " " + a.addTime());


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


    }
}
