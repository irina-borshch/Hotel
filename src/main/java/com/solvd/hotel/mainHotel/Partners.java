package com.solvd.hotel.mainHotel;

import com.solvd.hotel.invoice.Service;

import java.util.Objects;

public class Partners extends Address {
    private int partnerId;
    private String partnerName;
    private String phoneNumber;
    private Service service;

    public Partners() {
    }
    public Partners(String nameCountry, String city, String address,int partnerId, String partnerName,
                    String phoneNumber, Service service){
        super(nameCountry, city, address);
        this.partnerId = partnerId;
        this.partnerName = partnerName;
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

    @Override
    public String toString() {
        return getClass().getName() + "[nameCountry=" + getNameCountry() + ", city=" + getCity() + ", address=" + getAddress()
                + ", partnerId" + getPartnerId() + ", partnerName" + getPartnerName() +  ", phoneNumber" + getPhoneNumber()
        + ", service" +getService() + "]";
    }
    @Override
    public int hashCode () {
        return Objects.hash(getNameCountry().hashCode(), getCity().hashCode(), getAddress().hashCode(),
               getPartnerId(), getPartnerName().hashCode(), getPhoneNumber().hashCode(), getService().hashCode());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Partners partners = (Partners) o;

        return hashCode() == partners.hashCode();
    }
}
