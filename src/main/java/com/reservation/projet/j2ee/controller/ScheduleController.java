package com.reservation.projet.j2ee.controller;

import com.reservation.projet.j2ee.TimeSlotGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
public class ScheduleController {

    @GetMapping("/available-times")
    public ResponseEntity<List<String>> getAvailableTimes(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam("terrainId") Long terrainId) {
        // Simuler les heures d'ouverture du terrain de 8 AM à 12 AM (minuit)
        LocalTime openingTime = LocalTime.of(8, 0);  // 8:00 AM
        LocalTime closingTime = LocalTime.MIDNIGHT; // Correctly handle midnight
        int slotDurationInHours = 1; // Chaque créneau dure 1 heure

        List<String> availableTimes = TimeSlotGenerator.generateTimeSlots(openingTime, closingTime, slotDurationInHours);

        // TODO: Vérifiez les réservations existantes pour filtrer les créneaux non disponibles
        // Exemple : List<Reservation> existingReservations = reservationService.findByDateAndTerrainId(date, terrainId);
        // availableTimes = filterAvailableTimes(availableTimes, existingReservations);

        return ResponseEntity.ok(availableTimes);
    }
}
