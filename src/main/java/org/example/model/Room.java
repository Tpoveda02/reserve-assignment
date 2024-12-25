package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Map;
import java.util.HashMap;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    private RoomType type;
    private double price;
    private String features;
    private Map<LocalDate, Boolean> availability;

    // Constructor
    public Room(RoomType type, double price, String features) {
        this.type = type;
        this.price = price;
        this.features = features;
        this.availability = new HashMap<>();
    }

    // Getters y Setters
    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public Map<LocalDate, Boolean> getAvailability() {
        return availability;
    }

    public void setAvailability(Map<LocalDate, Boolean> availability) {
        this.availability = availability;
    }

}
