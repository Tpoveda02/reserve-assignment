package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    private String id;
    private RoomType type;
    private Map<LocalDate, Boolean> availability;

    public boolean isAvailable(Map<LocalDate, Boolean> availability, LocalDate startDate, LocalDate endDate) {
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            if (availability.getOrDefault(date, false)) {
                return false;
            }
        }
        return true;
    }

}
