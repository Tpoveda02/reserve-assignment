package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
    private double pricePartial;
    private double priceTotal;
    private double discount;
    private List<Room> rooms;

    // Método para calcular el precio total
    public double calculateTotalPrice(List<Room> rooms, LocalDate startDate, LocalDate endDate) {
        return 0;
    }

    public abstract List<Room> checkAvailableRooms(List<Room> availableRoomsByDate, int adults, int children, int rooms);


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

    public Room checkSingleRoomCapacity(List<Room> availableRooms, int totalPeople) {
        for (Room room : availableRooms) {
            if (room.getType().getPeopleByCountBeds() >= totalPeople) {
                return room;
            }
        }
        return null;
    }
}
