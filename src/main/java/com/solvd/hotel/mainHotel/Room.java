package com.solvd.hotel.mainHotel;

import com.solvd.hotel.enums.RoomType;
import com.solvd.hotel.interfaces.Cleanable;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Room implements Cleanable {
    private static final Logger logger = LogManager.getLogger(Room.class);

    private int floor;
    private int roomNumber;
    private RoomType type;
    private int roomId;
    private boolean isOccupiedRoom = false;

    public Room() {
    }

    public Room(int floor, int roomNumber, RoomType type, int roomId) {
        this.floor = floor;
        this.roomNumber = roomNumber;
        this.type = type;
        this.roomId = roomId;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomType getRoomType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public boolean isOccupiedRoom() {
        return isOccupiedRoom;
    }

    public Room setOccupiedRoom(boolean occupiedRoom) {
        isOccupiedRoom = occupiedRoom;
        return this;
    }

    @Override
    public void clean() {
        logger.info("This room must be cleaned!");
    }

    @Override
    public String getServiceType() {
        return getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return getClass().getName() + "[floor=" + getFloor() + ", roomNumber=" + getRoomNumber() + ", roomType="
                + getRoomType() + ", roomId=" + getRoomId() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFloor(), getRoomNumber(), getRoomType().hashCode(), getRoomId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return hashCode() == room.hashCode();
    }
}
