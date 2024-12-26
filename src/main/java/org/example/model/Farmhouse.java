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
public class Farmhouse extends Accommodation{

    private String description;
    private int numberOfRooms;
    //Constructor
    public Farmhouse(String id, String name, String city, double rating, double pricePartial, double priceTotal, double discount, List<Room> rooms, List<Booking> bookings) {
        super(id, name, city, rating, pricePartial, priceTotal, discount, rooms, bookings);
    }
    @Override
    public List<Room> checkAvailableRooms(List<Room> availableRoomsByDate, int adults, int children, int rooms) {
        int totalPeople = adults + children;
        List<Room> availableRoomsByCapacity = new ArrayList<>();
        availableRoomsByCapacity.add(checkSingleRoomCapacity(availableRoomsByDate, totalPeople));
        return availableRoomsByCapacity;
    }
}
