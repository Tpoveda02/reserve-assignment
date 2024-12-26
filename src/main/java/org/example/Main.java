package org.example;

import org.example.controller.AccommodationController;
import org.example.controller.BookingController;
import org.example.model.*;
import org.example.view.GeneralView;

import java.time.LocalDate;
import java.util.*;

public class Main {
    private static List<Accommodation> accommodations;

    static {
        // Inicializar datos de prueba
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

        accommodations = new ArrayList<>();
        RoomType roomTypeFarm = new RoomType("FT1", "Finca Grande 3 habitaciones", Map.of("Aire acondicionado", true, "Televisión", true), 100, 6);
        List<Room> roomF = new ArrayList<>();
        roomF.add(new Room("FT1", roomTypeFarm, new HashMap<>()));
        accommodations.add(new Farmhouse("A6", "Finca el Caribe", "Cartagena", 4.5, 900.0, 900.0, 0, roomF, new ArrayList<Booking>()));

        RoomType roomTypeApto = new RoomType("APT1", "Apartamento El Ideal 5 habitaciones", Map.of("Aire acondicionado", true, "Televisión", true), 100, 12);
        List<Room> roomApt = new ArrayList<>();
        roomApt.add(new Room("APT1", roomTypeApto, new HashMap<>()));
        accommodations.add(new Apartment("A7", "Apartamento el Sol", "Villavicencio", 4.5, 1200.0, 1200.0, 0, roomApt, new ArrayList<Booking>()));

        RoomType roomTypeDayPass = new RoomType("DATAPT1", "Entrada estandar", Map.of("Aire acondicionado", true, "Televisión", true), 100, 12);
        List<Room> roomDP = new ArrayList<>();
        roomDP.add(new Room("DAYP1", roomTypeDayPass, new HashMap<>()));
        accommodations.add(new DayPass("A8", "Dia soleado en Rosales", "Villavicencio", 4.5, 1200.0, 1200.0, 0, roomDP, new ArrayList<Booking>()));

        // Creación de hoteles
        accommodations.add(new Hotel("A1", "Hotel Caribe", "Cartagena", 4.5, roomTypes.get(0).getPrice(), 0, 0, rooms1, new ArrayList<Booking>()));
        accommodations.add(new Hotel("A2", "Hotel Andino", "Bogotá", 4.0, roomTypes.get(0).getPrice(), 0, 0, rooms2, new ArrayList<Booking>()));
        accommodations.add(new Hotel("A3", "Hotel Pacífico", "Buenaventura", 4.2, roomTypes.get(0).getPrice(), 0, 0, rooms3, new ArrayList<Booking>()));
        accommodations.add(new Hotel("A4", "Hotel Nevado", "Manizales", 3.8, roomTypes.get(0).getPrice(), 0, 0, rooms4, new ArrayList<Booking>()));
        accommodations.add(new Hotel("A5", "Hotel Llanero", "Villavicencio", 4.3, roomTypes.get(0).getPrice(), 0, 0, rooms5, new ArrayList<Booking>()));
    }

    public static void main(String[] args) {
        // Crear controlador y vista
        AccommodationController accommodationController = new AccommodationController();
        BookingController bookingController = new BookingController();
        GeneralView generalView = new GeneralView(accommodationController, bookingController);

        // Bucle de menú de opciones
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Buscar alojamientos");
            System.out.println("2. Realizar una reserva");
            System.out.println("3. Actualizar una reserva");
            System.out.println("4. Salir");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (option) {
                case 1:
                    accommodations = generalView.searchAndShowAccommodations(accommodations);
                    break;
                case 2:
                    accommodations = generalView.makeReservation(accommodations);
                    break;
                case 3:
                    accommodations = generalView.updateReservation(accommodations);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }

        System.out.println("Gracias por usar el sistema de reservas. ¡Hasta luego!");
    }
}
