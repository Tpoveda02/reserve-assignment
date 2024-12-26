package org.example.controller;

import org.example.model.Accommodation;
import org.example.model.Booking;
import org.example.model.Client;
import org.example.model.Room;
import org.example.view.GeneralView;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class BookingController {

    public BookingController() {
    }

    public Accommodation book(String id, String firstName, String lastName, String email, String nationality,
                              String phoneNumber, LocalDate birthdate, String arrivalTime, Accommodation accommodation,
                              LocalDate startDate, LocalDate endDate, int numPersonsEntered, int rooms) {

        Client clientBooking = new Client("C1", firstName, lastName, email, nationality, phoneNumber, birthdate);
        Accommodation selectedAccommodation = accommodation;
        List<Room> availableRoomsByAccommodation = accommodation.checkAvailableRooms(
                accommodation.findRoomsByDates(accommodation.getRooms(), startDate, endDate), numPersonsEntered, 0, rooms);

        if (!availableRoomsByAccommodation.isEmpty()) {
            Booking newBooking = new Booking(id, clientBooking, arrivalTime, startDate, endDate, numPersonsEntered, rooms, accommodation);
            newBooking.getAccommodation().setRooms(availableRoomsByAccommodation);
            List<Room> roomsOcupate = newBooking.getAccommodation().getRooms();
            for (Room room : roomsOcupate) {
                if (room.isAvailable(room.getAvailability(), startDate, endDate)) {
                    room.getAvailability().put(startDate, false);
                    room.getAvailability().put(endDate, false);
                }
            }
            newBooking.getAccommodation().setRooms(availableRoomsByAccommodation);
            newBooking.getAccommodation().calculateTotalPrice(accommodation.getRooms(), startDate, endDate);
            selectedAccommodation.addBooking(newBooking);
        }
        return selectedAccommodation;
    }


    public Room seletedRoom(String id, List<Room> rooms) {
        for (Room serchRoom : rooms) {
            if (serchRoom.getId().equals(id)) {
                return serchRoom;
            }
        }
        return null;
    }


    public Booking updateBooking(String email, LocalDate dateOfBirth, List<Accommodation> accommodations) {
        for (Accommodation accommodation : accommodations) {
            Booking booking = accommodation.findBookingByEmail(email, accommodation.getBookings());
            if (booking != null && booking.getClient().getBirthdate().equals(dateOfBirth)) {
                // Se encontró la reserva, proceder con la actualización
                return booking;
            }
        }
        return null;
    }
}
