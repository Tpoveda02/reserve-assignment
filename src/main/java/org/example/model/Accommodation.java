package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public abstract class Accommodation {
    private String id;
    private String name;
    private String city;
    private double rating;
    private double pricePartial;
    private double priceTotal;
    private double discount;
    private List<Room> rooms;
    private List<Booking> bookings;


    public abstract List<Room> checkAvailableRooms(List<Room> availableRoomsByDate, int adults, int children, int rooms);


    public List<Room> findRoomsByDates(List<Room> availableRooms, LocalDate startDate, LocalDate endDate) {
        List<Room> tempAvailableRooms = new ArrayList<>();
        for (Room room : availableRooms) {
            if (room.isAvailable(room.getAvailability(), startDate, endDate)) {
                tempAvailableRooms.add(room);
            }
        }
        availableRooms.addAll(tempAvailableRooms);
        return availableRooms;
    }

    public Room checkSingleRoomCapacity(List<Room> availableRooms, int totalPeople) {
        for (Room room : availableRooms) {
            if (room.getType().getPeopleByCountBeds() >= totalPeople) {
                return room;
            }
        }
        return null;
    }

    // Método para calcular el precio total
    public double calculateTotalPrice(List<Room> rooms, LocalDate startDate, LocalDate endDate) {
        double basePrice = getBasePrice(rooms, startDate, endDate);
        double adjustment = getAdjustmentPercentage(startDate, endDate);
        double adjustmentValue = basePrice * adjustment;
        double totalPrice = basePrice + adjustmentValue;
        this.pricePartial = basePrice;
        this.priceTotal = totalPrice;
        this.discount = getAdjustmentPercentage(startDate, endDate);

        return totalPrice;
    }

    // Método para calcular el precio base
    private double getBasePrice(List<Room> rooms, LocalDate startDate, LocalDate endDate) {
        long numberOfNights = ChronoUnit.DAYS.between(startDate, endDate);
        Room simpleRoom = rooms.stream().min((room1, room2) -> Double.compare(room1.getType().getPrice(), room2.getType().getPrice())).orElse(null);
        return (simpleRoom != null ? simpleRoom.getType().getPrice() : 0) * numberOfNights * rooms.size();
    }

    // Método para determinar el porcentaje de ajuste basado en las fechas de estadía
    private double getAdjustmentPercentage(LocalDate startDate, LocalDate endDate) {
        int startDay = startDate.getDayOfMonth();
        int endDay = endDate.getDayOfMonth();
        int daysInMonth = startDate.lengthOfMonth();

        if (endDay > daysInMonth - 5) {
            return 0.15; // Aumento del 15%
        } else if (startDay >= 10 && endDay <= 15) {
            return 0.10; // Aumento del 10%
        } else if (startDay >= 5 && endDay <= 10) {
            return -0.08; // Descuento del 8%
        } else {
            return 0.0; // Sin ajuste
        }
    }

    public void addBooking(Booking booking) {
        this.bookings.add(booking);
    }

    public boolean removeRoomById(String roomId) {
        return rooms.removeIf(room -> room.getId().equals(roomId));
    }

    public Booking findBookingByEmail(String email, List<Booking> bookings) {
        for (Booking booking : bookings) {
            if (booking.getClient().getEmail().equals(email)) {
                return booking;
            }
        }
        return null;
    }
}
