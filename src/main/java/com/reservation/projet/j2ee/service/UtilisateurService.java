package com.reservation.projet.j2ee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.reservation.projet.j2ee.entity.Utilisateur;
import com.reservation.projet.j2ee.repository.UtilisateurRepository;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<Utilisateur> getAllUsers() {
        return utilisateurRepository.findAll();
    }

    public Optional<Utilisateur> getUserById(Long userId) {
        return utilisateurRepository.findById(userId);
    }

    public Utilisateur createUser(Utilisateur user) {
        return utilisateurRepository.save(user);
    }

    public Utilisateur updateUser(Utilisateur user) {
        return utilisateurRepository.save(user);
    }

    public void deleteUser(Long userId) {
        utilisateurRepository.deleteById(userId);
    }
}
