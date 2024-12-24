package org.example.model;

import java.time.LocalDate;
import java.util.List;

public class Reservation {
    private Client client;
    private Accommodation accommodation;
    private LocalDate startDate;
    private LocalDate endDate;
    private int adults;
    private int children;
    private int numberOfRooms;
    private List<Room> roomsReserved;
    private double totalPrice;
    private double discountOrIncrease;

    //Constructor

    public Reservation(Client client, Accommodation accommodation, LocalDate startDate, LocalDate endDate, int adults, int children, int numberOfRooms, List<Room> roomsReserved, double totalPrice, double discountOrIncrease) {
        this.client = client;
        this.accommodation = accommodation;
        this.startDate = startDate;
        this.endDate = endDate;
        this.adults = adults;
        this.children = children;
        this.numberOfRooms = numberOfRooms;
        this.roomsReserved = roomsReserved;
        this.totalPrice = totalPrice;
        this.discountOrIncrease = discountOrIncrease;
    }

    //Getters and Setters

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public List<Room> getRoomsReserved() {
        return roomsReserved;
    }

    public void setRoomsReserved(List<Room> roomsReserved) {
        this.roomsReserved = roomsReserved;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getDiscountOrIncrease() {
        return discountOrIncrease;
    }

    public void setDiscountOrIncrease(double discountOrIncrease) {
        this.discountOrIncrease = discountOrIncrease;
    }
}
