package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
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
        // Verificar si el mapa de disponibilidad es nulo o está vacío
        if (availability == null || availability.isEmpty()) {
            // Si es nulo o vacío, asumimos que la habitación está disponible
            return true;
        }

        // Copiar el mapa de disponibilidad
        Map<LocalDate, Boolean> availabilityOfRoom = new HashMap<>(availability);

        // Verificar la disponibilidad para cada fecha en el rango
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            Boolean isAvailable = availabilityOfRoom.get(date);
            if (isAvailable != null && !isAvailable) {
                return false;
            }
        }
        return true;
    }

}
