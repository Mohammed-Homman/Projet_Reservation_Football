package com.reservation.projet.j2ee.service;

import io.micrometer.observation.ObservationFilter;
import jdk.jshell.execution.Util;
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
    public Optional<Utilisateur> getUserByCredentials(String email, String password) {
        return utilisateurRepository.findByEmailAndPassword(email, password);
    }


public Optional<Utilisateur> getUserById(Long userId) {
    return utilisateurRepository.findById(userId);
}
    public Utilisateur authenticate(String email, String password) {
        // Récupérer tous les utilisateurs avec cet e-mail
        List<Utilisateur> users = (List<Utilisateur>) utilisateurRepository.findByEmail(email);

        // Parcourir la liste des utilisateurs pour vérifier les mots de passe
        for (Utilisateur user : users) {
            if (user.getPassword().equals(password)) {
                return user; // Retourner true dès que le mot de passe correspond à l'un des utilisateurs
            }
        }

        return null; // Retourner false si aucun utilisateur correspondant n'a été trouvé
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
