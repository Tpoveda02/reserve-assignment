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
public class DayPass extends Accommodation{
    //Constructor
    public DayPass(String id, String name, String city, double rating, double pricePartial, double priceTotal, double discount, List<Room> rooms) {
        super(id, name, city, rating, pricePartial, priceTotal, discount, rooms);
    }

    @Override
    public List<Room> checkAvailableRooms(List<Room> availableRoomsByDate, int adults, int children, int rooms) {
        return null;
    }
}
