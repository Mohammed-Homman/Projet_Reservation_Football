package com.reservation.projet.j2ee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.reservation.projet.j2ee.entity.HistoriqueReservation;
import com.reservation.projet.j2ee.repository.HistoriqueReservationRepository;

@Service
public class HistoriqueReservationService {

    @Autowired
    private HistoriqueReservationRepository historiqueReservationRepository;

    public List<HistoriqueReservation> getAllHistoriqueReservations() {
        return historiqueReservationRepository.findAll();
    }

    public HistoriqueReservation createHistoriqueReservation(HistoriqueReservation historiqueReservation) {
        return historiqueReservationRepository.save(historiqueReservation);
    }
}
