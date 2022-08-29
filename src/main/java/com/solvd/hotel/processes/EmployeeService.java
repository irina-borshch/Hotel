package com.solvd.hotel.processes;

import com.solvd.hotel.people.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.Scanner;

public class EmployeeService {
    private static final Logger logger = LogManager.getLogger(EmployeeService.class);
    public Employee fillEmployeeInfo() {
        Scanner scan = new Scanner(System.in);
        Employee employee = new Employee();
        boolean isFirstNameValid = false;
        boolean isLastNameValid = false;
        boolean isPhoneNumberValid = false;
        boolean isWorkPositionValid = false;
        File employeeFile = new File("src/main/resources/employee.txt");
        do {
            logger.info("Enter your First Name: ");
            String firstName = scan.nextLine();
            if (firstName.matches("[A-Z][a-z]+")) {
                employee.setName(firstName);
                isFirstNameValid = true;
            } else {
                logger.info("Please use capital letters at the beginning of your First Name and do not use numbers.");
            }
        } while (!isFirstNameValid);
        do {
            logger.info("Enter your Last Name: ");
            String lastName = scan.nextLine();
            if (lastName.matches("[A-Z][a-z]+")) {
                employee.setLastName(lastName);
                isLastNameValid = true;
            } else {
                logger.info("Please use capital letters at the beginning of your Last Name and do not use numbers.");
            }
        } while (!isLastNameValid);
        do {
            logger.info("Enter your phone number by which our recruiter will contact you: ");
            String phoneNumber = scan.nextLine();
            if (phoneNumber.matches("[0-9]+")) {
                employee.setPhoneNumber(phoneNumber);

                isPhoneNumberValid = true;
            } else {
                logger.info("Please use only numbers to enter your phone number.");
            }
        } while (!isPhoneNumberValid);
        logger.info("Thank you for your information " + employee.getName() + " "  + employee.getLastName() + "! Our recruiter will contact you!");
        return employee;
    }
}
