package com.solvd.hotel.processes;

import com.solvd.hotel.exceptions.InvalidChoiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class CheckOutService {
    private final static Logger logger = LogManager.getLogger(CheckOutService.class);

    public static void payBill() {
        int choice;
        do {
            Scanner scanner = new Scanner(System.in);

            logger.info("Choose the action:" + '\n' +
                    "1) Pay a bill\n" +
                    "0) Back" + '\n' + "\n" +
                    "Make your choice:");
            choice = scanner.nextInt();
            try {
                if (choice == 1) {
                    PayForRoom.addPriceToBill();

                    break;
                } else if (choice == 0) {
                    logger.info("Exit from the Check out page. Now you are at the main page.");
                    break;

                } else {
                    throw new InvalidChoiceException("Invalid entering data. Please enter one of the provided numbers.");
                }
            } catch (InvalidChoiceException e) {
                logger.error(e);
            }
        } while (choice != 1 || choice != 2 || choice != 0);
    }

}

