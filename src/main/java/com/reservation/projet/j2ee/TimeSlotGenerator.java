package com.reservation.projet.j2ee;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TimeSlotGenerator {

    public static List<String> generateTimeSlots(LocalTime start, LocalTime end, int durationInHours) {
        List<String> slots = new ArrayList<>();
        LocalTime current = start;

        while (current.isBefore(end)) {
            LocalTime next = current.plusHours(durationInHours);
            if (!next.isAfter(end)) { // Assure que le créneau ne dépasse pas l'heure de fermeture
                slots.add(current.toString() + " - " + next.toString());
            }
            current = next;
        }

        return slots;
    }
}
