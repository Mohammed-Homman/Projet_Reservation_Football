package com.reservation.projet.j2ee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.reservation.projet.j2ee.entity.Utilisateur;
import com.reservation.projet.j2ee.service.UtilisateurService;
import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    // Retrieve all users
    @GetMapping
    public List<Utilisateur> getAllUsers() {
        return utilisateurService.getAllUsers();
    }

    // Retrieve user by ID
    @GetMapping("/{userId}")
    public ResponseEntity<Utilisateur> getUserById(@PathVariable Long userId) {
        return utilisateurService.getUserById(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/verifier")
    public Utilisateur login(@RequestBody Utilisateur utilisateur) {
        // Vérification des informations de connexion
        Utilisateur user = utilisateurService.authenticate(utilisateur.getEmail(), utilisateur.getPassword());
        if (user!=null) {

            return user;
        } else {
            return null;
        }
    }
  @PostMapping
    public Utilisateur createUser(@RequestBody Utilisateur user) {
        return utilisateurService.createUser(user);
    }

    // Update an existing user
    @PutMapping("/{userId}")
    public ResponseEntity<Utilisateur> updateUser(@PathVariable Long userId, @RequestBody Utilisateur user) {
        user.setId(userId);
        return ResponseEntity.ok(utilisateurService.updateUser(user));
    }

    // Delete a user
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        utilisateurService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
