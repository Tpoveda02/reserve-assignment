package org.example.controller;

import org.example.model.Reservation;
import org.example.view.GeneralView;

import java.util.List;

public class ReservationController {
    private List<Reservation> reservations;
    private GeneralView generalView;

    public ReservationController(List<Reservation> reservations, GeneralView generalView) {
        this.reservations = reservations;
        this.generalView = generalView;
    }

}
