package com.reservation.projet.j2ee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.reservation.projet.j2ee.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // Ajoutez des méthodes de requête personnalisées si nécessaire
}
