package com.reservation.projet.j2ee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.reservation.projet.j2ee.entity.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

}
