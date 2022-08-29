package com.solvd.hotel;

import com.solvd.hotel.processes.MainHotel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        MainHotel.mainHotel();
    }
}
