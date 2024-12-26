package org.example.controller;

import org.example.model.Booking;
import org.example.view.GeneralView;

import java.time.LocalDate;
import java.util.List;

public class BookingController {
    private List<Booking> bookings;
    private GeneralView generalView;

    public BookingController(List<Booking> bookings, GeneralView generalView) {
        this.bookings = bookings;
        this.generalView = generalView;
    }

    public String book(String nombre, String apellido, String email, String nacionalidad, String telefono, String horaLlegada, String hotelId, LocalDate startDate, LocalDate endDate) {
        return null;
    }
}
