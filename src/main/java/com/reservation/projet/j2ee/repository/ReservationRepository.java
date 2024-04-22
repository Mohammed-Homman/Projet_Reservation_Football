package com.reservation.projet.j2ee.repository;

import com.reservation.projet.j2ee.entity.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;
import com.reservation.projet.j2ee.entity.Reservation;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByDateReservationAndTerrain_Id(String date_reservation, Long id_terrain);
}