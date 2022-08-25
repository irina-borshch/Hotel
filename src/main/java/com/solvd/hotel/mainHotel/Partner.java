package com.solvd.hotel.mainHotel;

import com.solvd.hotel.enums.City;
import com.solvd.hotel.invoice.Service;

import java.util.Objects;

public class Partner extends Address {
    private int partnerId;
    private String partnerName;
    private String partnerLastName;
    private String phoneNumber;
    private Service service;

    public Partner() {
    }

    public Partner(String nameCountry, City city, String address, int partnerId, String partnerName, String partnerLastName,
                   String phoneNumber, Service service) {
        super(nameCountry, city, address);
        this.partnerId = partnerId;
        this.partnerName = partnerName;
        this.partnerLastName = partnerLastName;
        this.phoneNumber = phoneNumber;
        this.service = service;
    }

    public int getPartnerId() {
        return partnerId;
    }

    public void setPartnerID(int partnerId) {
        this.partnerId = partnerId;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getPartnerLastName() {
        return partnerLastName;
    }

    public void setPartnerLastName(String partnerLastName) {
        this.partnerLastName = partnerLastName;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[nameCountry=" + getNameCountry() + ", city=" + getCity() + ", address=" + getAddress()
                + ", partnerId" + getPartnerId() + ", partnerName" + getPartnerName() + ", phoneNumber" + getPhoneNumber()
                + ", service" + getService() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNameCountry().hashCode(), getCity().hashCode(), getAddress().hashCode(),
                getPartnerId(), getPartnerName().hashCode(), getPhoneNumber().hashCode(), getService().hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Partner partner = (Partner) o;

        return hashCode() == partner.hashCode();
    }

    /*public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }*/
}
