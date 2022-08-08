package com.solvd.hotel.invoice;

import com.solvd.hotel.interfaces.Cleanable;
import com.solvd.hotel.people.Guest;

import java.util.Objects;

public class Service implements Cleanable {
    private int serviceId;
    private Guest guest;
    private int employeeId;
    private String serviceName;
    private boolean additionalService;
    private double price;

    public Service() {

    }
    public Service(int serviceId, Guest guest, int employeeId, String serviceName, boolean additionalService,
                   double price) {
        this.serviceId = serviceId;
        this.guest = guest;
        this.employeeId = employeeId;
        this.serviceName = serviceName;
        this.additionalService = additionalService;
        this.price = price;
    }
    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public boolean getAdditionalService() {
        return additionalService;
    }

    public void setAdditionalService(boolean additionalService) {
        this.additionalService = additionalService;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void clean() {
        System.out.println("Cleaning service is needed!");
    }

    @Override
    public String getServiceType() {
        return getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return getClass().getName() + "[serviceId=" + getServiceId() + ", guest=" + getGuest() + ", employeeId="
                + getEmployeeId() + ", serviceName=" + getServiceName() + ", additionalService=" + getAdditionalService()
                + ", price" + getPrice() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getServiceId(), getGuest().hashCode(), getEmployeeId(), getServiceName().hashCode(),
                getAdditionalService(), getPrice());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return hashCode() == service.hashCode();
    }
}
