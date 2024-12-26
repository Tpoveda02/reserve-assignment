package org.example.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Hotel extends Accommodation {

    public Hotel(String id, String name, String city, double rating, double pricePartial, double priceTotal, double discount, List<Room> rooms) {
        super(id, name, city, rating, pricePartial, priceTotal, discount, rooms);
    }

    @Override
    public List<Room> checkAvailableRooms(List<Room> availableRoomsByDate, int adults, int children, int rooms) {
        int totalPeople = adults + children;
        if (rooms > 1) {
            System.out.println( "total" + totalPeople);
            return checkMultipleRoomsCapacity(availableRoomsByDate, totalPeople, rooms);
        } else {
            List<Room> availableRoomsByCapacity = new ArrayList<>();
            availableRoomsByCapacity.add(checkSingleRoomCapacity(availableRoomsByDate, totalPeople));
            return availableRoomsByCapacity;
        }
    }

    private List<Room> checkMultipleRoomsCapacity(List<Room> availableRooms, int totalPeople, int rooms) {
        List<Room> selectedRooms = new ArrayList<>();
        for (Room room : availableRooms) {
            if (room.getType().getPeopleByCountBeds() >= totalPeople/rooms) {
                rooms--;
                totalPeople -= room.getType().getPeopleByCountBeds();
                System.out.println(rooms + "total" + totalPeople);
                selectedRooms.add(room);
                if (rooms == 0) {
                    return selectedRooms;
                }
            }
        }
        return selectedRooms;
    }
}
