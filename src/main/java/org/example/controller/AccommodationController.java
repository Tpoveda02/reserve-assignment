package org.example.controller;

import org.example.model.Accommodation;
import org.example.model.Room;
import org.example.view.GeneralView;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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
        List<Accommodation> resultsAccomodations = new ArrayList<>();
        for (Accommodation accommodation : accommodations) {
            if (accommodation.getCity().equalsIgnoreCase(city) && accommodation.getClass().getSimpleName().equalsIgnoreCase(accommodationType)) {
                // Encuentra las habitaciones disponibles en las fechas dadas
                List<Room> availableRoomsByAccomodation = accommodation.findRoomsByDates(accommodation.getRooms(), startDate, endDate);

                // Verifica si las habitaciones encontradas cumplen con los requisitos de capacidad
                List<Room> roomsByCapacity = accommodation.checkAvailableRooms(availableRoomsByAccomodation, adults, children, rooms);

                if (!roomsByCapacity.isEmpty()) {
                    accommodation.setRooms(roomsByCapacity);
                    accommodation.calculateTotalPrice(accommodation.getRooms(), startDate, endDate);
                    resultsAccomodations.add(accommodation);
                }
            }
        }
        return resultsAccomodations;
    }

}
