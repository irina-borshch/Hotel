package com.solvd.hotel.exceptions;

import com.solvd.hotel.exceptions.AgeException;
import com.solvd.hotel.exceptions.DateException;
import com.solvd.hotel.invoice.Payment;
import com.solvd.hotel.logic.BookingOrder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hotel.logic.Booking;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.*;
import java.util.Date;

public class Check {
    private static final Logger logger = LogManager.getLogger(Check.class.getName());

    public void ageCheck(int age) throws AgeException {
        if (age < 18) {
            logger.info("AgeException: You can not make a booking. You must be of legal age or accompanied by an adult.");
        } else {
            logger.info("AgeException: You can book a room in our hotel.");
        }
    }
   Calendar date;
    public void dateCheck(Date date) throws DateException {
        Date date1 = new Date();
        if (date.getTime() > date1.getTime()) {
            logger.info("Invalid date. You can not make a booking order.");
            throw new DateException();
        }
    }
  /* BookingOrder order;
    Random random = new Random();
    try {
        order = new BookingOrder(new GregorianCalendar(random.nextInt(5) + 2021, 8, 6));
    }
    catch (DateException e) {
        logger.debug("Invalid date. You can not book a room");
        return;
    }*/
    /*Payment firstPayment;
    boolean success;
  public boolean paymentSuccess(Payment payment) {
      try {
          if (payment.success)
              logger.info("Payment was successful. Thank you for choosing our hotel.");
              // throw new InvalidPaymentException("Attempt to pay a bill");
          else
              logger.info("Payment was unsuccessful. Please try again.");
          throw new InvalidPaymentException("Something went wrong");
      } catch (InvalidPaymentException e) {
          logger.info("Payment ID:" + paymentId + ", success" + success);
      }
      return false;*/

}
