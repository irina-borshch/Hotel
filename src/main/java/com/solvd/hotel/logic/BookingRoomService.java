package com.solvd.hotel.logic;

import com.solvd.hotel.mainHotel.Room;
import com.solvd.hotel.enums.RoomType;

import java.util.Arrays;
import java.util.List;

public class BookingRoomService {

    private final List<Room> rooms = Arrays.asList(
            new Room(1, 11, RoomType.ECONOM, 11, 70),
            new Room(2, 22, RoomType.SINGLE, 22,100),
            new Room(3, 33, RoomType.PENTHOUSE, 33,400),
            new Room(2, 21, RoomType.ECONOM, 21,70),
            new Room(1, 12, RoomType.TRIPLE, 12,200),
            new Room(3, 31, RoomType.QUEEN, 31,300),
            new Room(3, 32, RoomType.DOUBLE, 32,150),
            new Room(2, 23, RoomType.SINGLE, 23,100),
            new Room(1, 33, RoomType.QUAD, 33,250));

    public Room getFreeRoom(RoomType type) {
        Room room = rooms.stream()
                .filter(it -> !it.isOccupiedRoom())
                .filter(preferredRoom -> {
                    if (type == null) return true;
                    else return preferredRoom.getRoomType() == type;
                })
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Can't find room for guest."));
        return room.setOccupiedRoom(true);
    }
}
