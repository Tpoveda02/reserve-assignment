package org.example.view;

import org.example.controller.AccommodationController;
import org.example.controller.BookingController;
import org.example.model.Accommodation;
import org.example.model.Booking;
import org.example.model.Hotel;
import org.example.model.Room;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GeneralView {

    private AccommodationController accommodationController;
    private BookingController bookingController;
    private int adults;
    private int children;
    private int numRooms;

    public GeneralView(AccommodationController accommodationController, BookingController bookingController) {
        this.accommodationController = accommodationController;
        this.bookingController = bookingController;
    }

    public List<Accommodation> searchAndShowAccommodations(List<Accommodation> accommodations) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar los parámetros al usuario
        /*
        System.out.println("Ingrese la ciudad:");
        String city = scanner.nextLine();
        System.out.println("Ingrese el tipo de alojamiento (Hotel, Apartamento, Finca, Día de Sol):");
        String accommodationType = scanner.nextLine();
        System.out.println("Ingrese el día de inicio del hospedaje (yyyy-mm-dd):");
        LocalDate startDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Ingrese el día de finalización del hospedaje (yyyy-mm-dd):");
        LocalDate endDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Ingrese cantidad de adultos:");
        adults = scanner.nextInt();
        System.out.println("Ingrese cantidad de ninos:");
        children = scanner.nextInt();
        System.out.println("Ingrese el numero de habitaciones:");
        numRooms = scanner.nextInt();
*/
        String city = "Villavicencio";
        String accommodationType = "Hotel";
        LocalDate startDate = LocalDate.parse("2025-04-15");
        LocalDate endDate = LocalDate.parse("2025-04-26");
        adults = 5;
        children = 1;
        numRooms = 2;
        List<Accommodation> originalAccommodations = List.copyOf(accommodations);

        // Realizar la búsqueda a través del controlador
        System.out.println("Alojamientos Disponibles:");
        accommodationController.searchAccommodations(originalAccommodations, city, accommodationType, startDate, endDate, adults, children, numRooms);
        // Mostrar los resultados
        return accommodations;
    }

    public List<Accommodation> makeReservation(List<Accommodation> accommodations) {
        Scanner scanner = new Scanner(System.in);
        // Solicitar los datos del cliente
        /*
        System.out.println("Ingrese su nombre:");
        String firstName = scanner.nextLine();
        System.out.println("Ingrese su apellido:");
        String lastName = scanner.nextLine();
        System.out.println("Ingrese su email:");
        String email = scanner.nextLine();
        System.out.println("Ingrese su nacionalidad:");
        String nationality = scanner.nextLine();
        System.out.println("Ingrese su número de teléfono:");
        String phoneNumber = scanner.nextLine();
        System.out.println("Ingrese la hora aproximada de llegada:");
        String arrivalTime = scanner.nextLine();
        System.out.println("Ingrese el ID del hotel:");
        Accommodation accommodation = accommodationController.findAccommodation(scanner.nextLine(), accommodations);
        System.out.println("Ingrese fecha de cumpleaños (yyyy-mm-dd):");
        LocalDate birthdate = LocalDate.parse(scanner.nextLine());
        System.out.println("Ingrese el día de inicio del hospedaje (yyyy-mm-dd):");
        LocalDate startDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Ingrese el día de finalización del hospedaje (yyyy-mm-dd):");
        LocalDate endDate = LocalDate.parse(scanner.nextLine());
           */
        String firstName = "Taniah";
        String lastName = "Poveda";
        String email = "taniah@gmail.com";
        String nationality = "Colombiana";
        String phoneNumber = "3007029830";
        String arrivalTime = "13:00";
        LocalDate birthdate = LocalDate.parse("2002-04-22");
        LocalDate startDate = LocalDate.parse("2025-04-15");
        LocalDate endDate = LocalDate.parse("2025-04-26");
        Accommodation accommodation = accommodationController.findAccommodation("A5", accommodations);
        // Realizar la reserva a través del controlador
        try {
            Accommodation updateAccommodation = bookingController.book("1BOK", firstName, lastName, email, nationality, phoneNumber,
                    birthdate, arrivalTime, accommodation, startDate, endDate, adults + children, numRooms);
            System.out.println("Se realizo la reserva con éxito");
            return accommodationController.updateAccommodation(updateAccommodation, accommodations);
        } catch (Exception e) {
            System.out.println("No se pudo realizar la reserva");
            return accommodations;
        }
    }

    public List<Accommodation> updateReservation(List<Accommodation> accommodations) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su email:");
        String email = scanner.nextLine();
        System.out.println("Ingrese su fecha de nacimiento (yyyy-mm-dd):");
        LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine());
        Booking booking = bookingController.updateBooking(email, dateOfBirth, accommodations);
        if (booking != null) {
            Accommodation updateAccommodation = accommodationController.findAccommodation(booking.getAccommodation().getId(), accommodations);
            return updateBookingDetails(updateAccommodation, booking, accommodations);

        } else {
            System.out.println("No se encontro ninguna reserva, verifique los datos ingresados");
        }
        return accommodations;
    }

    private List<Accommodation> updateBookingDetails(Accommodation accommodation, Booking booking, List<Accommodation> accommodations) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Datos de la reserva:");
        System.out.println("Nombre: " + booking.getClient().getFirstName());
        System.out.println("Apellido: " + booking.getClient().getLastName());
        System.out.println("Email: " + booking.getClient().getEmail());
        System.out.println("Nacionalidad: " + booking.getClient().getNationality());
        System.out.println("Teléfono: " + booking.getClient().getPhoneNumber());
        System.out.println("Hora de llegada: " + booking.getArrivalTime());
        System.out.println("Fecha de inicio: " + booking.getStartDate());
        System.out.println("Fecha de finalización: " + booking.getEndDate());
        System.out.println("¿Qué desea cambiar?");
        System.out.println("1. Cambiar habitación");
        System.out.println("2. Cambiar alojamiento");

        int option = scanner.nextInt();
        if (option == 1) {
            // Cambiar de habitación
            return accommodationController.updateAccommodation(changeRoom(accommodation, booking),accommodations);
        } else if (option == 2) {
            // Cambiar de alojamiento
            accommodation.getBookings().remove(booking);
            // Eliminar la reserva actual
            System.out.println("Reserva eliminada. Proceda a crear una nueva reserva.");
            return accommodationController.updateAccommodation(accommodation, accommodations);
        } else {
            System.out.println("Opción no válida");
        }

        return accommodations;
    }

    private Accommodation changeRoom(Accommodation accommodation, Booking booking) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Habitaciones ya reservadas: ");
        showRooms(booking.getAccommodation().getRooms());
        System.out.println("----------------------------");
        System.out.println("Ingrese el id de la habitacion que quiere cambiar: ");
        String idRoom = scanner.nextLine();
        Room room = bookingController.seletedRoom(idRoom, booking.getAccommodation().getRooms());
        List<Room> roomsAvailables = new ArrayList<Room>();
        System.out.println("Habitaciones disponibles:");
        accommodationController.showAvailableRoomsByAccommodation(accommodation, booking.getStartDate(), booking.getEndDate(), booking.getNumPersonsEntered() - room.getType().getPeopleByCountBeds(), 0, numRooms);
        for (Room room12 : accommodation.getRooms()) {
            System.out.println("  Identificador: " + room12.getId());
            System.out.println("  Tipo: " + room12.getType().getName());
            System.out.println("  Precio base: " + room12.getType().getPrice());
            System.out.println("  Características: " + room12.getType().getFeatures());
            System.out.println("  Disponibilidad: " + room12.getAvailability());
        }
        System.out.println("----------------------------");
        System.out.println("Ingrese el id de la nueva habitacion: ");
        String idNewRoom = scanner.nextLine();
        Room newRoom = bookingController.seletedRoom(idNewRoom, accommodation.getRooms());
        booking.getAccommodation().removeRoomById(room.getId());
        booking.getAccommodation().getRooms().add(newRoom);
        accommodation.updateBooking(booking, accommodation.getBookings());
        System.out.println("----------------------------");
        System.out.println("Reserva actualizada");
        return accommodation;
    }

    public void showRooms(List<Room> rooms) {
        for (Room room : rooms) {
            System.out.println("  Identificador: " + room.getId());
            System.out.println("  Tipo: " + room.getType().getName());
            System.out.println("  Precio por noche: " + room.getType().getPrice());
            System.out.println("  Características: " + room.getType().getFeatures());
            System.out.println("  Disponibilidad: " + room.getAvailability());
        }
    }

}
