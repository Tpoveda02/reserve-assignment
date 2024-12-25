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
    private double basicPrice;
    private Map<LocalDate, Boolean> availability;

}
