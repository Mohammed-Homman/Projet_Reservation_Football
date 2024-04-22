package com.reservation.projet.j2ee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.reservation.projet.j2ee.entity.Utilisateur;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Optional<Utilisateur> findByEmailAndPassword(String email, String password);

    List<Utilisateur> findByEmail(String email);
}
