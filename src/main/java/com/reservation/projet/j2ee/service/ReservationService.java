package com.reservation.projet.j2ee.service;

import com.reservation.projet.j2ee.entity.Reservation;
import com.reservation.projet.j2ee.entity.Terrain;
import com.reservation.projet.j2ee.entity.Utilisateur;
import com.reservation.projet.j2ee.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ReservationService {
    @Autowired
    public ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found with id: " + id));
    }
    public List<Reservation> authenticate(String date_reservation, Long id_terrain){
        List<Reservation> reservations = (List<Reservation>) reservationRepository.findAllByDateReservationAndTerrain_Id(date_reservation,id_terrain);

        for (Reservation reservation : reservations) {
            if (reservation.getDateReservation().equals(date_reservation)) {
                return reservations;
            }
        }

        return null;
    }


    public Reservation createReservation(Reservation reservation) {
        // Logique pour créer une réservation en lien avec une équipe
        // Vous devrez implémenter cette logique en fonction de vos besoins
        return reservationRepository.save(reservation);
    }


    public void deleteReservation(Long id) {
        if (!reservationRepository.existsById(id)) {
            throw new EntityNotFoundException("Reservation not found with id: " + id);
        }
        reservationRepository.deleteById(id);
    }

    }
