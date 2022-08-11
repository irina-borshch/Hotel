package com.solvd.hotel.interfaces;

import com.solvd.hotel.logic.CheckIn;

public interface Checkable {
    boolean checkIn(CheckIn checkIn);

    public void approveNumberOfGuests();

    public void checkPersonalInfo();
    //CheckIn checkDate();
    //void ageCheck(CheckIn checkIn);
}
