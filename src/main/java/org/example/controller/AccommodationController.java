package org.example.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.model.Accommodation;
import org.example.model.Room;
import org.example.view.GeneralView;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
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
                Accommodation newAccommodation = findAvailableRoomsByAccommodation(accommodation,startDate,endDate,adults,children,rooms);
                if (newAccommodation != null)
                    resultsAccomodations.add(accommodation);
            }
        }
        return resultsAccomodations;
    }
    public Accommodation findAvailableRoomsByAccommodation(Accommodation accommodation, LocalDate startDate, LocalDate endDate, int adults, int children, int rooms){
        List<Room> availableRoomsByAccommodation = accommodation.checkAvailableRooms(
                accommodation.findRoomsByDates(accommodation.getRooms(), startDate, endDate), adults, children, rooms);
        if (!availableRoomsByAccommodation.isEmpty()) {
            accommodation.setRooms(availableRoomsByAccommodation);
            accommodation.calculateTotalPrice(accommodation.getRooms(), startDate, endDate);
            return accommodation;
        }
        return null;
    }

    public Accommodation findAccommodation(String id, List<Accommodation> accommodations) {
        for (Accommodation accommodation : accommodations) {
            if (accommodation.getId().equals(id)) {
                return accommodation;
            }
        }
        return null;
    }
}
