package com.solvd.hotel.people;

import com.solvd.hotel.interfaces.IPersonInfo;

import java.util.Objects;

import com.solvd.hotel.mainHotel.Room;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Employee extends Person implements IPersonInfo {
    private static final Logger logger = LogManager.getLogger(Employee.class);
    private String workPosition;
    private String phoneNumber;
    private double salary;
    private int workerID;

    public Employee() {

    }

    public Employee(String name, String lastName, int age, String workPosition, String phoneNumber, double salary, int workerID) {
        super(name, lastName, age);
        this.workPosition = workPosition;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.workerID = workerID;
    }

    public String getWorkPosition() {
        return workPosition;
    }

    public void setWorkPosition(String workPosition) {
        this.workPosition = workPosition;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getWorkerID() {
        return workerID;
    }

    public void setWorkerID(int workerID) {
        this.workerID = workerID;
    }

    @Override
    public void introduce() {
        System.out.println("I'm " + getName() + " " + getLastName() + ". I am working on position  " + getWorkPosition()
                + ". My working phone number is" + getPhoneNumber());
    }

    @Override
    public void printBio() {
        logger.info("I am " + getName() + " " + getLastName() + " " + getAge());
    }

    @Override
    public String toString() {
        return getClass().getName() + "[name=" + getName() + ", lastName=" + getLastName() + ", age=" + getAge() +
                ", workPosition=" + getWorkPosition() + ", phoneNumber=" + getPhoneNumber() + ", salary=" + getSalary()
                + ", workerID=" + getWorkerID() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName().hashCode(), getLastName().hashCode(), getWorkPosition().hashCode(),
                getPhoneNumber().hashCode(), getSalary(), getWorkerID());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return hashCode() == employee.hashCode();
    }
}
