package com.reservation.projet.j2ee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.reservation.projet.j2ee.entity.Utilisateur;
import com.reservation.projet.j2ee.service.UtilisateurService;
import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping
    public List<Utilisateur> getAllUsers() {
        return utilisateurService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public Utilisateur getUserById(@PathVariable Long userId) {
        return utilisateurService.getUserById(userId)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec l'ID : " + userId));
    }

    @PostMapping
    public Utilisateur createUser(@RequestBody Utilisateur user) {
        return utilisateurService.createUser(user);
    }

    @PutMapping("/{userId}")
    public Utilisateur updateUser(@PathVariable Long userId, @RequestBody Utilisateur user) {
        user.setId(userId);
        return utilisateurService.updateUser(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        utilisateurService.deleteUser(userId);
    }
}
