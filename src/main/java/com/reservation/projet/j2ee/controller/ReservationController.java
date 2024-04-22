package com.reservation.projet.j2ee.controller;

import com.reservation.projet.j2ee.entity.Reservation;
import com.reservation.projet.j2ee.entity.Terrain;
import com.reservation.projet.j2ee.entity.Utilisateur;
import com.reservation.projet.j2ee.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.persistence.EntityNotFoundException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    public ReservationService reservationService;

    @PostMapping("/search")
    public List<String> getAllReservationByDateTerrain(@RequestBody Map<String, Object> request) {
        // Extract date_reservation and id_terrain from the request body
        List<String> datesReserver = new ArrayList<>();
        String date_reservation = (String) request.get("date_reservation");
        Long id_terrain = ((Number) request.get("id_terrain")).longValue(); // Convertir en Long
        // Vérification des informations de connexion
        List<Reservation> reservations = reservationService.authenticate(date_reservation, id_terrain);
        if (reservations != null) {
            for (Reservation r: reservations){
                datesReserver.add(r.getHeure_reservation()) ;

            }
            return datesReserver;

        } else {
            return null;
        }
    }


    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservations();
        return ResponseEntity.ok().body(reservations);
    }

    @PostMapping("/validate")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        try {
            Reservation createdReservation = reservationService.createReservation(reservation);
            return ResponseEntity.ok().body(createdReservation);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable("id") Long id) {
        try {
            Reservation reservation = reservationService.getReservationById(id);
            return ResponseEntity.ok().body(reservation);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable("id") Long id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }
}
