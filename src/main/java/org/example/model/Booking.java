package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    private String id;
    private Client client;
    private String arrivalTime;
    private String hotelId;
    private LocalDate startDate;
    private LocalDate endDate;

}
