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

    public void searchAndDisplayAccommodations() {
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

    }


}
