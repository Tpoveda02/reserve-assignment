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

    public Hotel(String id, String name, String city, double rating, double pricePerNight, List<Room> rooms) {
        super(id, name, city, rating, pricePerNight, rooms);
    }

    @Override
    public double calculateTotalPrice(LocalDate startDate, LocalDate endDate, List<Room> rooms) {
        // Implementa la lógica de cálculo de precio total aquí.
        return 0;
    }
    @Override
    public List<Room> checkAvailableRooms(List<Room> availableRoomsByDate, int adults, int children, int rooms) {
        int totalPeople = adults + children;
        if (rooms > 1) {
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
            if (room.getType().getPeopleByCountBeds() >= totalPeople) {
                rooms--;
                totalPeople -= room.getType().getPeopleByCountBeds();
                selectedRooms.add(room);
                if (rooms == 0) {
                    return selectedRooms;
                }
            }
        }
        return selectedRooms;
    }
}
