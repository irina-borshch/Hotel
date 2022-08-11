package com.solvd.hotel.mainHotel;

import com.solvd.hotel.interfaces.IReceptionCall;
import com.solvd.hotel.people.Employee;
import com.solvd.hotel.invoice.Service;

import java.util.List;
import java.util.Objects;

public class HotelInfo extends Address implements IReceptionCall {
    private String hotelName;
    private String description;
    private int stars;
    private List<Room> rooms;
    private List<Employee> employees;
    private List<Service> services;

    public HotelInfo() {

    }

    public HotelInfo(String hotelName, String nameCountry, String city, String address, String description,
                     int stars, List<Room> rooms, List<Employee> employees,
                     List<Service> services) {
        super(nameCountry, city, address);
        this.hotelName = hotelName;
        this.description = description;
        this.stars = stars;
        this.rooms = rooms;
        this.employees = employees;
        this.services = services;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[hotelName" + getHotelName() + ", nameCountry=" + getNameCountry() +
                ", city=" + getCity() + ", address=" + getAddress() + ", stars" + getStars()
                + ", rooms" + getRooms() + ", employees" + getEmployees() + ", services" + getServices() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHotelName().hashCode(), getNameCountry().hashCode(), getCity().hashCode(),
                getAddress().hashCode(), getStars(), getRooms().hashCode(),
                getEmployees().hashCode(), getServices().hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HotelInfo hotelInfo = (HotelInfo) o;
        return hashCode() == hotelInfo.hashCode();
    }
}