package com.reservation.projet.j2ee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.reservation.projet.j2ee.entity.Terrain;

public interface TerrainRepository extends JpaRepository<Terrain, Long> {
    // Ajoutez des méthodes de requête personnalisées si nécessaire
}
