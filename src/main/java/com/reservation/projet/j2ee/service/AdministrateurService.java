package com.reservation.projet.j2ee.service;

import com.reservation.projet.j2ee.entity.Administrateur;
import com.reservation.projet.j2ee.repository.AdministrateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministrateurService {

    @Autowired
    private AdministrateurRepository administrateurRepository;

    public List<Administrateur> getAllAdministrateurs() {
        return administrateurRepository.findAll();
    }

    public Optional<Administrateur> getAdministrateurById(Long administrateurId) {
        return administrateurRepository.findById(administrateurId);
    }

    public Administrateur createAdministrateur(Administrateur administrateur) {
        return administrateurRepository.save(administrateur);
    }

    public Administrateur updateAdministrateur(Administrateur administrateur) {
        return administrateurRepository.save(administrateur);
    }

    public void deleteAdministrateur(Long administrateurId) {
        administrateurRepository.deleteById(administrateurId);
    }
}
