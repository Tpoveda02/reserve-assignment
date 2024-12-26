package org.example.controller;

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

    public String book(String firstName, String lastName, String email, String nationality, String phoneNumber, LocalTime birthdate, String arrivalTime, String accommodationId, LocalDate startDate, LocalDate endDate) {
        Client clientBooking = new Client("C1",firstName, lastName,email,nationality,phoneNumber, birthdate);
        Booking newBooking = new Booking("R1", clientBooking, arrivalTime, accommodationId, startDate, endDate);
        return "Reserva creada";
    }
}
