package com.reservation.projet.j2ee.controller;

import com.reservation.projet.j2ee.entity.Horaire;
import com.reservation.projet.j2ee.service.HoraireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/horaires")
public class HoraireController {

    @Autowired
    private HoraireService horaireService;

    @GetMapping
    public ResponseEntity<List<Horaire>> getAllHoraires() {
        List<Horaire> horaires = horaireService.getAllHoraires();
        return ResponseEntity.ok().body(horaires);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Horaire> getHoraireById(@PathVariable("id") Long id) {
        Optional<Horaire> horaireOptional = horaireService.getHoraireById(id);
        if (horaireOptional.isPresent()) {
            Horaire horaire = horaireOptional.get();
            horaire.getReservations();
            return ResponseEntity.ok().body(horaire);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Horaire> createHoraire(@RequestBody Horaire horaire) {
        Horaire createdHoraire = horaireService.saveHoraire(horaire);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHoraire);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHoraire(@PathVariable("id") Long id) {
        horaireService.deleteHoraire(id);
        return ResponseEntity.noContent().build();
    }
}
