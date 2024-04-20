package com.reservation.projet.j2ee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.reservation.projet.j2ee.entity.HistoriqueReservation;

public interface HistoriqueReservationRepository extends JpaRepository<HistoriqueReservation, Long> {
    // Ajoutez des méthodes de requête personnalisées si nécessaire
}
