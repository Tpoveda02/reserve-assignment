package org.example.view;

import org.example.controller.AccommodationController;
import org.example.model.Accommodation;
import org.example.model.Room;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class GeneralView {

    private AccommodationController accommodationController;

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
        int adults = scanner.nextInt();

        System.out.println("Ingrese cantidad de ninos:");
        int children = scanner.nextInt();

        System.out.println("Ingrese el numero de habitaciones:");
        int rooms = scanner.nextInt();

        // Realizar la búsqueda a través del controlador
        List<Accommodation> foundAccommodations = accommodationController.searchAccommodations(city, accommodationType, startDate, endDate, adults, children, rooms);
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
            for (Room room : accommodation.getRooms()) {
                System.out.println("  Tipo: " + room.getType().getName());
                System.out.println("  Precio por noche: " + room.getType().getPrice());
                System.out.println("  Características: " + room.getType().getFeatures());
            }
            System.out.println("----------------------------");
        }
    }


}
