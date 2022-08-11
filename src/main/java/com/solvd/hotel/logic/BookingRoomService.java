package com.solvd.hotel.logic;

import com.solvd.hotel.mainHotel.Room;
import com.solvd.hotel.mainHotel.RoomType;

import java.util.Arrays;
import java.util.List;

public class BookingRoomService {

    private List<Room> rooms = Arrays.asList(
            new Room(1, 11, RoomType.ECONOM, 11),
            new Room(2, 22, RoomType.SINGLE, 22),
            new Room(3, 33, RoomType.PENTHOUSE, 33),
            new Room(2, 21, RoomType.ECONOM, 21),
            new Room(1, 12, RoomType.TRIPLE, 12),
            new Room(3, 31, RoomType.QUEEN, 31),
            new Room(3, 32, RoomType.DOUBLE, 32),
            new Room(2, 23, RoomType.SINGLE, 23),
            new Room(1, 33, RoomType.QUAD, 33));

    public Room getFreeRoom(RoomType type) {
        Room room = rooms.stream()
                .filter(it -> !it.isOccupiedRoom())
                .filter(preferredRoom -> preferredRoom.getRoomType() == type)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Can't find room for guest"));
        return room.setOccupiedRoom(true);
    }
}
