package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Accommodation {
    private String id;
    private String name;
    private String city;
    private double rating;
    private double pricePerNight;
    private List<Room> rooms;

    public abstract double calculateTotalPrice(LocalDate startDate, LocalDate endDate, List<Room> rooms);

    public List<Room> findRoomsByDates(List<Room> availableRooms, LocalDate startDate, LocalDate endDate) {
        List<Room> tempAvailableRooms = new ArrayList<>();
        for (Room room : availableRooms) {
            if (room.isAvailable(room.getAvailability(), startDate, endDate)) {
                tempAvailableRooms.add(room);
            }
        }
        availableRooms.addAll(tempAvailableRooms);
        return availableRooms;
    }
}
