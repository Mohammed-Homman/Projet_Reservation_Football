package com.reservation.projet.j2ee.service;

import com.reservation.projet.j2ee.entity.Horaire;
import com.reservation.projet.j2ee.repository.HoraireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HoraireService {

    @Autowired
    private HoraireRepository horaireRepository;

    public Optional<Horaire> getHoraireById(Long id) {
        return horaireRepository.findById(id);
    }

    public Horaire saveHoraire(Horaire horaire) {
        return horaireRepository.save(horaire);
    }

    public List<Horaire> getAllHoraires() {
        return horaireRepository.findAll();
    }

    public void deleteHoraire(Long id) {
        horaireRepository.deleteById(id);
    }
}
