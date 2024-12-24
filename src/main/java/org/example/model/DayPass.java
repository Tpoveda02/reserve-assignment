package org.example.model;

import java.time.LocalDate;
import java.util.List;

public class DayPass extends Accommodation{
    //Constructor
    public DayPass(String id, String name, String city, double rating, double pricePerNight, List<Room> rooms) {
        super(id, name, city, rating, pricePerNight, rooms);
    }

    @Override
    public double calculateTotalPrice(LocalDate startDate, LocalDate endDate, List<Room> rooms) {
        return 0;
    }
}
