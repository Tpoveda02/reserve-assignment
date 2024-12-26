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

    public GeneralView(AccommodationController accommodationController) {
        this.accommodationController = accommodationController;
    }

    public void searchAndShowAccommodations() {
        Scanner scanner = new Scanner(System.in);

        // Solicitar los parámetros al usuario
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

        // Realizar la búsqueda a través del controlador
        List<Accommodation> foundAccommodations = accommodationController.searchAccommodations(city, accommodationType, startDate, endDate, adults, children, numRooms);
        // Mostrar los resultados
        showAccommodations(foundAccommodations, startDate, endDate);
    }

    public void showAccommodations(List<Accommodation> accommodations, LocalDate startDate, LocalDate endDate) {
        System.out.println("Alojamientos Disponibles:");
        for (Accommodation accommodation : accommodations) {
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
        // Realizar la reserva a través del controlador
        String resultado = bookingController.book("1BOK", firstName, lastName, email, nationality, phoneNumber, birthdate, arrivalTime, accommodation, startDate, endDate, adults + children, numRooms);
        // Mostrar el resultado de la reserva
        System.out.println(resultado);
    }

    public void updateReservation(List<Accommodation> accommodations) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su email:");
        String email = scanner.nextLine();
        System.out.println("Ingrese su fecha de nacimiento (yyyy-mm-dd):");
        LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine());
        boolean access = bookingController.updateBooking(email, dateOfBirth, accommodations);
    }



    private void showRooms(List<Room> rooms) {
        for (Room room : rooms) {
            System.out.println("  Identificador: " + room.getId());
            System.out.println("  Tipo: " + room.getType().getName());
            System.out.println("  Precio por noche: " + room.getType().getPrice());
            System.out.println("  Características: " + room.getType().getFeatures());
        }
    }

}
