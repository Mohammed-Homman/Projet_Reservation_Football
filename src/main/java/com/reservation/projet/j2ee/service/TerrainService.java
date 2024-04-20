package com.reservation.projet.j2ee.service;

import com.reservation.projet.j2ee.entity.Terrain;
import com.reservation.projet.j2ee.repository.TerrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TerrainService {

    @Autowired
    private TerrainRepository terrainRepository;

    public List<Terrain> getAllTerrains() {
        return terrainRepository.findAll();
    }

    public Terrain getTerrainById(Long id) {
        Optional<Terrain> terrainOptional = terrainRepository.findById(id);
        return terrainOptional.orElseThrow(() -> new RuntimeException("Terrain not found with id: " + id));
    }

    public Terrain saveTerrain(Terrain terrain) {
        return terrainRepository.save(terrain);
    }

    public void deleteTerrain(Long id) {
        terrainRepository.deleteById(id);
    }
}
