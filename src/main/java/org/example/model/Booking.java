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
public class Booking {
    private String id;
    private Client client;
    private String arrivalTime;
    private LocalDate startDate;
    private LocalDate endDate;
    private int numPersonsEntered;
    private int numRooms;
    private Accommodation accommodation;

    public Booking generateBook(String id, Client clientBooking, String arrivalTime, Accommodation accommodation, LocalDate startDate, LocalDate endDate, int numPersonsEntered, int numRooms) {
        // Disminuir la cantidad de habitaciones disponibles
        List<Room> rooms = accommodation.getRooms();
        for (Room room : rooms) {
            if (room.isAvailable(room.getAvailability(), startDate, endDate)) {
                room.getAvailability().put(startDate, false);
                room.getAvailability().put(endDate, false);
            }
        }
        accommodation.setRooms(rooms);
        // Crear registro de reserva
        Booking booking = new Booking(id, clientBooking, arrivalTime, startDate, endDate, numPersonsEntered, numRooms, accommodation);
        return booking;
    }


}
