package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class Apartment extends Accommodation{
    private String description;
    private int numberOfRooms;
    //Constructor
    public Apartment(String id, String name, String city, double rating, double pricePerNight, List<Room> rooms) {
        super(id, name, city, rating, pricePerNight, rooms);
    }

    @Override
    public double calculateTotalPrice(LocalDate startDate, LocalDate endDate, List<Room> rooms) {
        return 0;
    }
}
