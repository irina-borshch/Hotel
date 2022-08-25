package com.solvd.hotel.processes;

import com.solvd.hotel.people.Guest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hotel.mainHotel.Partner;

import java.io.File;
import java.util.Scanner;


public class PartnerService {
    private static final Logger logger = LogManager.getLogger(PartnerService.class);

    public Partner fillPartnerInfo() {
        Scanner scan = new Scanner(System.in);
        Partner partner = new Partner();
        boolean isFirstNameValid = false;
        boolean isLastNameValid = false;
        boolean isPhoneNumberValid = false;
        File partnerFile = new File("src/main/resources/partner.txt");
        do {
            logger.info("Enter your First Name: ");
            String firstName = scan.nextLine();
            if (firstName.matches("[A-Z][a-z]+")) {
                partner.setPartnerName(firstName);
                isFirstNameValid = true;
            } else {
                logger.info("Please use capital letters at the beginning of your First Name and do not use numbers.");
            }
        } while (!isFirstNameValid);
        do {
            logger.info("Enter your Last Name: ");
            String lastName = scan.nextLine();
            if (lastName.matches("[A-Z][a-z]+")) {
                partner.setPartnerLastName(lastName);
                isLastNameValid = true;
            } else {
                logger.info("Please use capital letters at the beginning of your Last Name and do not use numbers.");
            }
        } while (!isLastNameValid);
        do {
            logger.info("Enter your phone number by which our manager will contact you: ");
            String phoneNumber = scan.nextLine();
            if (phoneNumber.matches("[0-9]+")) {
                partner.setPhoneNumber(phoneNumber);

                isPhoneNumberValid = true;
            } else {
                logger.info("Please use only numbers to enter your phone number.");
            }
        } while (!isPhoneNumberValid);
        logger.info("Thank you for your information! Our manager will contact you!");
        return partner;

    }
}

