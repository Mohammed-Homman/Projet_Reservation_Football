package com.reservation.projet.j2ee.repository;

import com.reservation.projet.j2ee.entity.Horaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HoraireRepository extends JpaRepository<Horaire, Long> {
}
