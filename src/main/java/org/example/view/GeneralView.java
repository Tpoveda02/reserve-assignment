package org.example.view;

import org.example.controller.AccommodationController;
import org.example.controller.BookingController;
import org.example.model.Accommodation;
import org.example.model.Booking;
import org.example.model.Hotel;
import org.example.model.Room;

import java.time.LocalDate;
import java.time.LocalTime;
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

    public void searchAndShowAccommodations() {
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

        // Realizar la búsqueda a través del controlador
        List<Accommodation> foundAccommodations = accommodationController.searchAccommodations(city, accommodationType, startDate, endDate, adults, children, numRooms);
        // Mostrar los resultados
        showAccommodations(foundAccommodations, startDate, endDate);
    }

    public void showAccommodations(List<Accommodation> accommodations, LocalDate startDate, LocalDate endDate) {
        System.out.println("Alojamientos Disponibles:");
        for (Accommodation accommodation : accommodations) {
            System.out.println("Identificador: " + accommodation.getId());
            System.out.println("Nombre: " + accommodation.getName());
            System.out.println("Ciudad: " + accommodation.getCity());
            System.out.println("Calificación: " + accommodation.getRating());
            System.out.println("Precio total: " + accommodation.getPriceTotal());
            System.out.println("Precio Descontado/Adicional : " + (accommodation.getPriceTotal() - accommodation.getPricePartial()));
            System.out.println("Porcentaje Descontado/Adicional: " + accommodation.getDiscount());
            System.out.println("Habitaciones: ");
            showRooms(accommodation.getRooms());
            System.out.println("----------------------------");
        }
    }

    public void makeReservation(List<Accommodation> accommodations) {
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
        String lastName = "Taniah";
        String email = "Taniah";
        String nationality = "Taniah";
        String phoneNumber = "Taniah";
        String arrivalTime = "Taniah";
        LocalDate birthdate = LocalDate.parse("2002-04-22");
        LocalDate startDate = LocalDate.parse("2025-04-15");
        LocalDate endDate = LocalDate.parse("2025-04-26");
        Accommodation accommodation = accommodationController.findAccommodation("A5", accommodations);
        // Realizar la reserva a través del controlador
        System.out.println(endDate);
        try {
            bookingController.book("1BOK", firstName, lastName, email, nationality, phoneNumber,
                    birthdate, arrivalTime, accommodation, startDate, endDate, adults + children, numRooms);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        // Mostrar el resultado de la reserva

    }

    public void updateReservation(List<Accommodation> accommodations) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su email:");
        String email = scanner.nextLine();
        System.out.println("Ingrese su fecha de nacimiento (yyyy-mm-dd):");
        LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine());
        Booking booking = bookingController.updateBooking(email, dateOfBirth, accommodations);
        if(booking != null){
            updateBookingDetails(accommodationController.findAccommodation(booking.getAccommodationId(),accommodations), booking);
        }else{
            System.out.println("No se encontro ninguna reserva, verifique los datos ingresados");
        }
    }

    private void updateBookingDetails(Accommodation accommodation, Booking booking) {
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
            changeRoom(accommodation, booking);
        } else if (option == 2) {
            // Cambiar de alojamiento
            accommodation.getBookings().remove(booking);
            // Eliminar la reserva actual
            System.out.println( "Reserva eliminada. Proceda a crear una nueva reserva.");
        } else {
            System.out.println( "Opción no válida");
        }
    }
    private void changeRoom(Accommodation accommodation, Booking booking) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Habitaciones ya reservadas: " + accommodation.getRooms());
        showRooms(accommodation.getRooms());
        System.out.println("----------------------------");
        System.out.println("Ingrese el id de la habitacion que quiere cambiar: ");
        String idRoom = scanner.nextLine();
        Room room = bookingController.seletedRoom(idRoom, accommodation.getRooms());
        List<Room> roomsAvailables = accommodationController.findAvailableRoomsByAccommodation(
                accommodation, booking.getStartDate(), booking.getEndDate(),
                booking.getNumPersonsEntered() - room.getType().getPeopleByCountBeds(), 0, numRooms).getRooms();
        System.out.println("Habitaciones disponibles:");
        showRooms(roomsAvailables);
        System.out.println("----------------------------");
        System.out.println("Ingrese el id de la nueva habitacion: ");
        String idNewRoom = scanner.nextLine();
        Room newRoom = bookingController.seletedRoom(idRoom, accommodation.getRooms());
        accommodation.removeRoomById(room.getId());
        accommodation.getRooms().add(newRoom);
        System.out.println("----------------------------");
        System.out.println("Reserva actualizada");
    }

    private void showRooms (List < Room > rooms) {
            for (Room room : rooms) {
                System.out.println("  Identificador: " + room.getId());
                System.out.println("  Tipo: " + room.getType().getName());
                System.out.println("  Precio por noche: " + room.getType().getPrice());
                System.out.println("  Características: " + room.getType().getFeatures());
            }
        }

    }
