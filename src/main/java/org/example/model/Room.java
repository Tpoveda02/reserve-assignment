package org.example.model;

public class Room {
    private String type;
    private double price;
    private String features;
    private int quantityAvailable;

    // Constructor
    public Room(String type, double price, String features, int quantityAvailable) {
        this.type = type;
        this.price = price;
        this.features = features;
        this.quantityAvailable = quantityAvailable;
    }
    //Getters and Setters

    public String getType() {
        return type;
    }

    public void setType(String type) {
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

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }
}
