package org.example.model;

import java.time.LocalDate;
import java.util.List;

public abstract class Accommodation {

    private String id;
    private String name;
    private String city;
    private double rating;
    private double pricePerNight;
    private List<Room> rooms;

    // Constructor
    public Accommodation(String id, String name, String city, double rating, double pricePerNight, List<Room> rooms) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.rating = rating;
        this.pricePerNight = pricePerNight;
        this.rooms = rooms;
    }


    //Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public abstract double calculateTotalPrice(LocalDate startDate, LocalDate endDate, List<Room> rooms);
}
