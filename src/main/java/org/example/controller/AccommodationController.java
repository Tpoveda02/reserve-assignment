package org.example.controller;

import org.example.model.Accommodation;
import org.example.view.GeneralView;

import java.time.LocalDate;
import java.util.List;

public class AccommodationController {
    private List<Accommodation> accommodations;
    private GeneralView generalView;

    public AccommodationController(List<Accommodation> accommodations, GeneralView generalView) {
        this.accommodations = accommodations;
        this.generalView = generalView;
    }

    public AccommodationController(List<Accommodation> accommodations) {
        this.accommodations = accommodations;
    }

    public List<Accommodation> searchAccommodations(String city, String accommodationType, LocalDate startDate, LocalDate endDate, int adults, int children, int rooms) {
        return null;
    }

}
