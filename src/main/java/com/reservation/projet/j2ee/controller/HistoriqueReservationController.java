package com.reservation.projet.j2ee.controller;

import com.reservation.projet.j2ee.entity.HistoriqueReservation;
import com.reservation.projet.j2ee.service.HistoriqueReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historique-reservations")
public class HistoriqueReservationController {

    @Autowired
    private HistoriqueReservationService historiqueReservationService;

    @GetMapping
    public ResponseEntity<List<HistoriqueReservation>> getAllHistoriqueReservations() {
        List<HistoriqueReservation> historiqueReservations = historiqueReservationService.getAllHistoriqueReservations();
        return new ResponseEntity<>(historiqueReservations, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HistoriqueReservation> createHistoriqueReservation(@RequestBody HistoriqueReservation historiqueReservation) {
        HistoriqueReservation createdHistoriqueReservation = historiqueReservationService.createHistoriqueReservation(historiqueReservation);
        return new ResponseEntity<>(createdHistoriqueReservation, HttpStatus.CREATED);
    }
}
