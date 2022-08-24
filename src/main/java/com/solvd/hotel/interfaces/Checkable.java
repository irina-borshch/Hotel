package com.solvd.hotel.interfaces;

import com.solvd.hotel.logic.CheckIn;
import com.solvd.hotel.people.Guest;

public interface Checkable {
    boolean checkCheckIn(Guest guest);

    /*public void approveNumberOfGuests();

    public void checkPersonalInfo();
    //CheckIn checkDate();
    //void ageCheck(CheckIn checkIn);*/
}
