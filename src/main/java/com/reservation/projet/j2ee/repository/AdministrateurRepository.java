package com.reservation.projet.j2ee.repository;

import com.reservation.projet.j2ee.entity.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministrateurRepository extends JpaRepository<Administrateur,Long> {
}
