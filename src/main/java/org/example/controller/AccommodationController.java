package org.example.controller;

import org.example.model.Accommodation;
import org.example.view.GeneralView;

import java.util.List;

public class AccommodationController {
    private List<Accommodation> accommodations;
    private GeneralView generalView;

    public AccommodationController(List<Accommodation> accommodations, GeneralView generalView) {
        this.accommodations = accommodations;
        this.generalView = generalView;
    }
}
