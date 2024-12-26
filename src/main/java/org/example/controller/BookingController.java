package org.example.controller;

import org.example.model.Accommodation;
import org.example.model.Booking;
import org.example.model.Client;
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

    public String book(String firstName, String lastName, String email, String nationality, String phoneNumber, LocalTime birthdate, String arrivalTime, Accommodation accommodation, LocalDate startDate, LocalDate endDate) {
        Client clientBooking = new Client("C1",firstName, lastName,email,nationality,phoneNumber, birthdate);
        Booking newBooking = new Booking();
        newBooking = newBooking.generateBook("R1", clientBooking, arrivalTime, accommodation, startDate, endDate);

         accommodation.addBooking(newBooking);
         // Añadir la reserva al alojamiento
            return "Se ha realizado la reserva con éxito";
    }

}
