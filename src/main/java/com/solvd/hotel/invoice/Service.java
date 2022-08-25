package com.solvd.hotel.invoice;

import com.solvd.hotel.interfaces.Cleanable;
import com.solvd.hotel.people.Guest;
import com.solvd.hotel.enums.AdditionalService;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Service implements Cleanable {

    private AdditionalService serviceName;
    private int price;


    public Service() {

    }

    public Service(AdditionalService serviceName, int price) {

        this.serviceName = serviceName;
        this.price = price;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public AdditionalService getServiceName() {
        return serviceName;
    }

    public void setServiceName(AdditionalService serviceName) {
        this.serviceName = serviceName;
    }


    @Override
    public void clean() {
        System.out.println("Cleaning service is needed!");
    }

    @Override
    public String getServiceType() {
        return getClass().getSimpleName();
    }

   /* @Override
    public String toString() {
        return getClass().getName() + "[serviceId=" + getServiceId() + ", guest=" + getGuest() + ", employeeId="
                + getEmployeeId() + ", serviceName=" + getServiceName() + ", additionalService=" + getAdditionalService()
                + ", price" + getPrice() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getServiceId(), getGuest().hashCode(), getEmployeeId(), getServiceName().hashCode(),
                getAdditionalService(), getPrice());
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return hashCode() == service.hashCode();
    }
}
