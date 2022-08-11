package com.solvd.hotel.logic;

import com.solvd.hotel.invoice.Payment;
import com.solvd.hotel.invoice.Service;
import com.solvd.hotel.people.Guest;

import java.util.List;
import java.util.Objects;

public class CheckOut extends Reservation {
    private int roomNum;
    private Payment payment;
    private List<Service> services;

    public CheckOut(List<Guest> guests, int roomNum, double price, Payment payment,
                    List<Service> services) {
        super(guests, price);
        this.roomNum = roomNum;
        this.payment = payment;
        this.services = services;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[guest=" + getGuests() + ", roomNum=" + getRoomNum()
                + ", price=" + getPrice() + ", payment=" + getPayment() + ", services" + getServices() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGuests().hashCode(), getRoomNum(),
                getPrice(), getPayment().hashCode(), getServices().hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckOut checkOut = (CheckOut) o;
        return hashCode() == checkOut.hashCode();
    }
}
