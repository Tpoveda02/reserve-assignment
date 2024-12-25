package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    private Client client;
    private Accommodation accommodation;
    private LocalDate startDate;
    private LocalDate endDate;
    private int adults;
    private int children;
    private int numberOfRooms;
    private List<Room> roomsReserved;
    private double totalPrice;
    private double discountOrIncrease;

}
