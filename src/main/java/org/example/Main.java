package org.example;

import org.example.controller.AccommodationController;
import org.example.controller.BookingController;
import org.example.model.*;
import org.example.view.GeneralView;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Inicializar datos de prueba
        // Tipos de habitación
        List<RoomType> roomTypes = new ArrayList<>();
        roomTypes.add(new RoomType("RT1", "Habitación Sencilla", Map.of("Aire acondicionado", true, "Televisión", true), 100, 1));
        roomTypes.add(new RoomType("RT2", "Habitación Doble", Map.of("Aire acondicionado", true, "Televisión", true, "Minibar", true), 150, 2));
        roomTypes.add(new RoomType("RT3", "Suite Junior", Map.of("Aire acondicionado", true, "Televisión", true, "Minibar", true, "Sala de estar", true), 200, 2));
        roomTypes.add(new RoomType("RT4", "Suite Ejecutiva", Map.of("Aire acondicionado", true, "Televisión", true, "Minibar", true, "Sala de estar", true, "Jacuzzi", true), 250, 2));
        roomTypes.add(new RoomType("RT5", "Habitación Familiar", Map.of("Aire acondicionado", true, "Televisión", true, "Minibar", true, "Sala de estar", true, "Cocina", true), 300, 4));

        // Creación de habitaciones
        List<Room> rooms1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            rooms1.add(new Room("R" + (i + 1), roomTypes.get(i % 5), new HashMap<>()));
        }

        List<Room> rooms2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            rooms2.add(new Room("R" + (i + 1), roomTypes.get(i % 5), new HashMap<>()));
        }

        List<Room> rooms3 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            rooms3.add(new Room("R" + (i + 1), roomTypes.get(i % 5), new HashMap<>()));
        }

        List<Room> rooms4 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            rooms4.add(new Room("R" + (i + 1), roomTypes.get(i % 5), new HashMap<>()));
        }

        List<Room> rooms5 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            rooms5.add(new Room("R" + (i + 1), roomTypes.get(i % 5), new HashMap<>()));
        }

        // Creación de hoteles
        List<Accommodation> accommodations = new ArrayList<>();
        accommodations.add(new Hotel("A1", "Hotel Caribe", "Cartagena", 4.5, 300.0,0,0, rooms1,new ArrayList<Booking>()));
        accommodations.add(new Hotel("A2", "Hotel Andino", "Bogotá", 4.0, 250.0,0,0, rooms2,new ArrayList<Booking>()));
        accommodations.add(new Hotel("A3", "Hotel Pacífico", "Buenaventura", 4.2, 280.0,0,0, rooms3,new ArrayList<Booking>()));
        accommodations.add(new Hotel("A4", "Hotel Nevado", "Manizales", 3.8, 230.0,0,0, rooms4,new ArrayList<Booking>()));
        accommodations.add(new Hotel("A5", "Hotel Llanero", "Villavicencio", 4.3, 290.0,0,0, rooms5,new ArrayList<Booking>()));

        // Impresión para verificar
        accommodations.forEach(accommodation -> {
            System.out.println("Accommodation: " + accommodation.getName() + " in " + accommodation.getCity());
            accommodation.getRooms().forEach(room -> {
                System.out.println("  Room ID: " + room.getId() + ", Type: " + room.getType().getName());
            });
        });


        // Configurar disponibilidad de habitaciones
        LocalDate date1 = LocalDate.of(2024, 12, 24);
        LocalDate date2 = LocalDate.of(2024, 12, 25);

        // Crear controlador y vista
        AccommodationController accommodationController = new AccommodationController(accommodations);
        BookingController bookingController = new BookingController(accommodations);
        GeneralView generalView = new GeneralView(accommodationController,bookingController);

        // Ejecutar la comprobación de disponibilidad
        generalView.searchAndShowAccommodations();
        generalView.makeReservation(accommodations);
        generalView.updateReservation(accommodations);
    }
}
