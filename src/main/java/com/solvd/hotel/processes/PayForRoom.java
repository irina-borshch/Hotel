package com.solvd.hotel.processes;

import com.solvd.hotel.enums.RoomType;
import com.solvd.hotel.enums.AdditionalService;
import com.solvd.hotel.exceptions.InvalidChoiceException;
import com.solvd.hotel.invoice.InvoiceDetails;
import com.solvd.hotel.invoice.Payment;
import com.solvd.hotel.invoice.Service;
import com.solvd.hotel.mainHotel.Room;
import com.solvd.hotel.people.Guest;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.File;
import java.io.IOException;
import java.util.*;

public class PayForRoom {
    private static double totalPrice = 0;
    private final static List<String> invoice = new ArrayList<>();
    private final static Logger logger = LogManager.getLogger(PayForRoom.class);
    public final static List<Room> rooms = List.of(
            new Room(1, 11, RoomType.ECONOM, 11, 70),
            new Room(2, 22, RoomType.SINGLE, 22, 100),
            new Room(3, 33, RoomType.PENTHOUSE, 33, 400),
            new Room(1, 12, RoomType.TRIPLE, 12, 200),
            new Room(3, 31, RoomType.QUEEN, 31, 300),
            new Room(3, 32, RoomType.DOUBLE, 32, 150),
            new Room(1, 33, RoomType.QUAD, 33, 250));
    public final static List<Service> services = List.of(
            new Service(AdditionalService.BREAKFAST_DELIVERY, 50),
            new Service(AdditionalService.LUNCH_DELIVERY, 50),
            new Service(AdditionalService.DINNER_DELIVERY, 50),
            new Service(AdditionalService.TAXI_ORDER, 15),
            new Service(AdditionalService.CITY_GUIDE, 100),
            new Service(AdditionalService.SPA, 150),
            new Service(AdditionalService.CAR_RENTAL, 165),
            new Service(AdditionalService.RESTAURANT_BOOKING, 25),
            new Service(AdditionalService.CLEANING, 85));
    static Guest guest = new Guest();


    public static void showRooms() {
        rooms.forEach(room -> logger.info(rooms));
    }

    public static void addPriceToBill() {
        logger.info("Enter the room type of occupied room:");
        findByRoomType();
        //continueCountingPrice();

    }


    public static void findByRoomType() {
        Scanner scanner = new Scanner(System.in);
        String occupiedRoom = scanner.nextLine();
        boolean notMatchRoomType = true;
        try {
            for (Room room : rooms) {
                if (occupiedRoom.equalsIgnoreCase(room.getRoomType().toString())) {
                    occupiedRoom = room.getRoomType().toString();
                    logger.info("Your occupied room is added to the total bill: " + occupiedRoom);
                    invoice.add(occupiedRoom);
                    logger.info("Enter amount days of stay:");
                    guest.setDaysOfStay(scanner.nextInt());
                    totalPrice = totalPrice + room.getPrice() * guest.daysOfStay;
                    logger.info("Total price for the order is: $" + totalPrice);
                    notMatchRoomType = false;
                }
            }
            if (!notMatchRoomType) {
                continueCountingPrice();
            } else {
                logger.info("Invalid room type room number. Please try again.");
                findByRoomType();
            }
        } catch (RuntimeException e) {
            logger.info(e);
        }

    }

    public static void continueCountingPrice() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            logger.info("Did you use extra service?\n" +
                    "1) Yes. Add extra service to total bill.\n" +
                    "2) No, did not use extra services.");
            choice = scanner.nextInt();
            try {

                if (choice == 1) {
                    addExtraServicesToBill();
                } else if (choice == 2) {
                    logger.info("Your payment amount: " + totalPrice);
                    invoice.forEach(logger::info);
                    paymentOrder();
                    break;
                } else {
                    throw new InvalidChoiceException("Incorrect choice. Please enter one of the provided numbers.");
                }
            } catch (InvalidChoiceException e) {
                logger.error(e);
            }
        } while (choice != 0);

    }


    public static void addExtraServicesToBill() {
        logger.info("Enter the service type you used:");
        Scanner scanner = new Scanner(System.in);
        String extraService = scanner.nextLine();
        boolean notMatchServiceName = true;
        for (Service service : services) {
            if (extraService.equalsIgnoreCase(String.valueOf(service.getServiceName()))) {
                extraService = String.valueOf(service);
                logger.info("Your extra service is added to the total bill: " + extraService);
                invoice.add(extraService);
                totalPrice = totalPrice + service.getPrice();
                logger.info("Total price is: $" + totalPrice);
                notMatchServiceName = false;
            }
        }
        if (notMatchServiceName) {
            logger.info("Invalid entering extra service. Please try again.");
            addPriceToBill();
        }
    }

    public static void paymentOrder() {
        Scanner scanner = new Scanner(System.in);
        String cardNumber;
        boolean confirmPaying = false;
        String guestName;
        String guestLastName;
        String paymentID = UUID.randomUUID().toString();
        Calendar date = Calendar.getInstance();
        List<String> guestData = new ArrayList<>();

        File guestFile = new File("src/main/resources/payment.txt");
        logger.info("Pay a bill:");
        Guest guest = new Guest();
        logger.info("Enter your First name:");
        guestName = scanner.nextLine();
        guest.setName(guestName);
        guestData.add("First Name: " + guest.getName());
        logger.info("Enter your Last Name:");
        guestLastName = scanner.nextLine();
        guest.setLastName(guestLastName);
        guestData.add("Last Name: " + guest.getLastName());


        guestData.add("Date: " + date.getTime());
        guestData.add("Your bill:" + paymentID);
        guestData.add("Total price: $" + totalPrice);
        new Payment(paymentID, guestName, new Date(), true);
        try {
            FileUtils.writeLines(guestFile, guestData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        do {
            logger.info("Total price to pay: $" + totalPrice + ". Confirm your invoice (write 'OK')");
            String confirmation = scanner.nextLine();
            if (Objects.equals(confirmation, "OK")) {
                confirmPaying = true;
                InvoiceDetails.invoiceDetails();
                break;
            } else {
                logger.info("Please write 'OK' to confirm your order.");
            }
        } while (!confirmPaying);
    }

}
