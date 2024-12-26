package org.example.controller;

import org.example.model.Accommodation;
import org.example.model.Booking;
import org.example.model.Client;
import org.example.model.Room;
import org.example.view.GeneralView;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class BookingController {
    private List<Booking> bookings;
    private GeneralView generalView;

    public BookingController(List<Booking> bookings, GeneralView generalView) {
        this.bookings = bookings;
        this.generalView = generalView;
    }

    public String book(String id, String firstName, String lastName, String email, String nationality,
                       String phoneNumber, LocalDate birthdate, String arrivalTime, Accommodation accommodation,
                       LocalDate startDate, LocalDate endDate, int numPersonsEntered, int rooms) {
        Client clientBooking = new Client("C1", firstName, lastName, email, nationality, phoneNumber, birthdate);
        Booking newBooking = new Booking();
        newBooking = newBooking.generateBook(id, clientBooking, arrivalTime, accommodation, startDate, endDate, numPersonsEntered, rooms);
        // Añadir la reserva al alojamiento
        accommodation.addBooking(newBooking);
        return "Se ha realizado la reserva con éxito";
    }


    public Room seletedRoom(String id, List<Room> rooms) {
        for (Room serchRoom : rooms) {
            if (serchRoom.getId().equals(id)) {
                return serchRoom;
            }
        }
        return null;
    }


    public Boolean updateBooking(String email, LocalDate dateOfBirth, List<Accommodation> accommodations) {
        for (Accommodation accommodation : accommodations) {
            Booking booking = accommodation.findBookingByEmail(email,accommodation.getBookings());
            if (booking != null && booking.getClient().getBirthdate().equals(dateOfBirth)) {
                // Se encontró la reserva, proceder con la actualización
                return true;
            }
        }
        return false;
    }
}
