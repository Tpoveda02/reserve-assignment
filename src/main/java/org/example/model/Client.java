package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String nationality;
    private String phoneNumber;
    private LocalTime birthdate;


}
