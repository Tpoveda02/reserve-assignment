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

    public List<Accommodation> searchAccommodations(List<Accommodation> accommodations, String city, String accommodationType, LocalDate startDate, LocalDate endDate, int adults, int children, int rooms) {
        this.accommodations = accommodations;
        List<Accommodation> resultsAccommodations = new ArrayList<>();
        for (Accommodation accommodation : accommodations) {
            if (accommodation.getCity().equalsIgnoreCase(city) && accommodation.getClass().getSimpleName().equalsIgnoreCase(accommodationType)) {
                Accommodation newAccommodation = showAvailableRoomsByAccommodation(cloneAccommodation(accommodation).get(0), startDate, endDate, adults, children, rooms);
                if (newAccommodation != null) {
                    resultsAccommodations.add(newAccommodation);
                }
            }
        }
        return resultsAccommodations;
    }

    private List<Accommodation> cloneAccommodation(Accommodation accommodation) {
        List<Accommodation> accommodationList = new ArrayList<>();
        // Aquí necesitarías implementar un método que clone el objeto Accommodation profundamente, incluyendo sus habitaciones.
        accommodationList.add(accommodation);
        return accommodationList; // Esto es un pseudocódigo. Necesitarás implementar un clonador real.
    }

    public Accommodation showAvailableRoomsByAccommodation(Accommodation accommodation, LocalDate startDate, LocalDate endDate, int adults, int children, int rooms) {
        List<Room> availableRoomsByAccommodation = accommodation.checkAvailableRooms(
                accommodation.findRoomsByDates(accommodation.getRooms(), startDate, endDate), adults, children, rooms);
        if (!availableRoomsByAccommodation.isEmpty()) {
            accommodation.calculateTotalPrice(accommodation.getRooms(), startDate, endDate);
            System.out.println("Identificador: " + accommodation.getId());
            System.out.println("Nombre: " + accommodation.getName());
            System.out.println("Ciudad: " + accommodation.getCity());
            System.out.println("Calificación: " + accommodation.getRating());
            System.out.println("Precio total: " + accommodation.getPriceTotal());
            System.out.println("Precio Descontado/Adicional : " + (accommodation.getPriceTotal() - accommodation.getPricePartial()));
            System.out.println("Porcentaje Descontado/Adicional: " + accommodation.getDiscount());
            System.out.println("Habitaciones: ");
            for (Room room : availableRoomsByAccommodation) {
                System.out.println("  Identificador: " + room.getId());
                System.out.println("  Tipo: " + room.getType().getName());
                System.out.println("  Precio por noche: " + room.getType().getPrice());
                System.out.println("  Características: " + room.getType().getFeatures());
                System.out.println("  Disponibilidad: " + room.getAvailability());
            }
            System.out.println("----------------------------");
            return accommodation;
        }
        return null;
    }

    public Accommodation findAvailableRoomsByAccommodation(Accommodation accommodation, LocalDate startDate, LocalDate endDate, int adults, int children, int rooms) {
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

    public List<Accommodation> updateAccommodation(Accommodation updateAccommodation, List<Accommodation> accommodations) {
        List<Accommodation> updateAccommodations = new ArrayList<Accommodation>();
        for (Accommodation accommodation : accommodations) {
            if (accommodation.getId().equals(updateAccommodation.getId())) {
                updateAccommodations.add(updateAccommodation);
            } else {
                updateAccommodations.add(accommodation);
            }
        }
        return updateAccommodations;
    }
}
