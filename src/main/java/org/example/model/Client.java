package org.example.model;

import java.time.LocalTime;

public class Client {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String nationality;
    private String phoneNumber;
    private LocalTime birthdate;

    //Constructor
    public Client(String id, String firstName, String lastName, String email, String nationality, String phoneNumber, LocalTime birthdate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.nationality = nationality;
        this.phoneNumber = phoneNumber;
        this.birthdate = birthdate;
    }
    //Getters and Setters


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalTime getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalTime birthdate) {
        this.birthdate = birthdate;
    }
}
