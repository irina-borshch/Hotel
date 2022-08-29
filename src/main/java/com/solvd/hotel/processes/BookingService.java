package com.solvd.hotel.processes;

import com.solvd.hotel.exceptions.AgeException;
import com.solvd.hotel.logic.BookingOrder;
import com.solvd.hotel.people.Guest;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.lang.String;

public class BookingService {
    public static final List<BookingOrder> bookingOrders = new ArrayList<>();
    private static final Logger logger = LogManager.getLogger(BookingService.class);

    public Guest fillGuestInfo() throws IOException, AgeException {
        Scanner scan = new Scanner(System.in);
        Guest guest = new Guest();
        Integer age = null;
        Random rand = new Random();
        int generateBookingOrder = rand.nextInt(888);
        boolean isFirstNameValid = false;
        boolean isLastNameValid = false;
        boolean isAgeValid = false;
        boolean isDaysOfStayValid = false;
        File guestFile = new File("src/main/resources/guest.txt");
        //}
        do {
            logger.info("Enter amount of days you want to stay: ");
            int daysOfStay = scan.nextInt();
            if (String.valueOf(daysOfStay).matches("[0-9]+")) {
                guest.setDaysOfStay(daysOfStay);
                isDaysOfStayValid = true;
            } else {
                logger.info("Please use only numbers to indicate amount of days you want to stay.");
            }
        } while (!isDaysOfStayValid);
        do {
            logger.info("Enter your First Name: ");
            Scanner sc = new Scanner(System.in);
            String firstName = sc.nextLine();
            if (firstName.matches("[A-Z][a-z]+")) {
                guest.setName(firstName);
                isFirstNameValid = true;
            } else {
                logger.info("Please use capital letters at the beginning of your First Name and do not use numbers.");
            }
        } while (!isFirstNameValid);

        do {
            logger.info("Enter your Last Name: ");
            Scanner sc = new Scanner(System.in);
            String lastName = sc.nextLine();
            if (lastName.matches("[A-Z][a-z]+")) {
                guest.setLastName(lastName);
                isLastNameValid = true;
            } else {
                logger.info("Please use capital letters at the beginning of your Last Name and do not use numbers.");
            }
        } while (!isLastNameValid);

        logger.info("Please, indicate your age:");
        while (age == null) {
            try {
                age = scan.nextInt();
            } catch (RuntimeException e) {
                logger.info("Your input age is invalid. Please try again");
            }
        }
        if (age >= 18) {
            guest.setAge(age);


            logger.info("Thank you for booking creating!");
            guest.setBookingOrder(StringUtils.upperCase(StringUtils.truncate(guest.getName(), 1)) + "-" +
                    StringUtils.upperCase(StringUtils.truncate(guest.getLastName(), 2)) + "-" +
                    generateBookingOrder);
            bookingOrders.add(new BookingOrder(guest.getBookingOrder()));

            logger.info("Dear " + guest.getName() + " " + guest.getLastName() + "! You've successfully created a booking. Your booking order is: " +
                    guest.getBookingOrder());

            return guest;

        } else {
            logger.info("You can not be checked in. You must be of legal age or accompanied by an adult");
            throw new AgeException("Your age is " + age + ". That is why you can not be checked in. You must be over 18 years old");
        }
    }

}


