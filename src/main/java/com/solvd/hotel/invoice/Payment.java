package com.solvd.hotel.invoice;

import com.solvd.hotel.people.Guest;
import com.solvd.hotel.interfaces.IPaymentSuccess;
import com.solvd.hotel.exceptions.InvalidPaymentException;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Payment implements IPaymentSuccess {
    private static final Logger logger = LogManager.getLogger(Payment.class.getName());

    private int paymentId;
    private Guest guest;
    private Date date;
    private List<Service> services;
    private boolean additionalService;
    private List<AdditionalService> AdditionalServices;
    private double amount;
    private boolean success;

    public Payment() {
    }

    public Payment(int paymentId, Guest guest, Date date, List<Service> services, boolean additionalService,
                   List<AdditionalService> AdditionalServices, double amount, boolean success) {
        this.paymentId = paymentId;
        this.guest = guest;
        this.date = date;
        this.services = services;
        this.additionalService = additionalService;
        this.AdditionalServices = AdditionalServices;
        this.amount = amount;
        this.success = success;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public boolean isAdditionalService() {
        return additionalService;
    }

    public void setAdditionalService(boolean additionalService) {
        this.additionalService = additionalService;
    }

    public List<AdditionalService> getAdditionalServices() {
        return AdditionalServices;
    }

    public void setAdditionalServices(List<AdditionalService> AdditionalServices) {
        this.AdditionalServices = AdditionalServices;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[paymentId=" + getPaymentId() + ", guest=" + getGuest() + ", date=" + getDate()
                + ", services" + getServices() + ", additionalServices" + getAdditionalServices() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPaymentId(), getGuest().hashCode(), getDate().hashCode(), getServices().hashCode(),
                getAdditionalServices().hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        return hashCode() == payment.hashCode();
    }

    @Override
    public double getPrice() {
        return 0;
    }

    /*@Override*/
    public boolean paymentSuccess(Payment payment) {
        try {
            if (payment.success)
                logger.info("Payment was successful. Thank you for choosing our hotel.");

            else
                logger.info("Payment was unsuccessful. Please try again.");
            throw new InvalidPaymentException("Something went wrong");
        } catch (InvalidPaymentException e) {
            logger.info("Payment ID:" + paymentId + ", success" + success);

        }
        return false;

    }
}

