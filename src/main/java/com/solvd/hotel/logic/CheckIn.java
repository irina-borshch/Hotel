package com.solvd.hotel.logic;

import com.solvd.hotel.enums.RoomType;
import com.solvd.hotel.mainHotel.Room;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;


public class CheckIn {
    private static final Logger logger = LogManager.getLogger(CheckIn.class);

    private RoomType preferredRoom;
    private Room selectedRoom;


    public CheckIn(RoomType preferredRoom) {
        this.preferredRoom = preferredRoom;
    }


    public RoomType getRoomType() {
        return preferredRoom;
    }

    public void setRoomType(RoomType type) {
        this.preferredRoom = type;
    }


    public Room getSelectedRoom() {
        return selectedRoom;
    }

    public void setSelectedRoom(Room selectedRoom) {
        this.selectedRoom = selectedRoom;
    }


    @Override
    public String toString() {
        return getClass().getName() + "[roomType=" + getRoomType() + ", roomNum="
                + ", checkedIn" + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoomType().hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckIn checkIn = (CheckIn) o;
        return hashCode() == checkIn.hashCode();
    }
}




