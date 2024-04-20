package com.reservation.projet.j2ee.controller;

import com.reservation.projet.j2ee.entity.Administrateur;
import com.reservation.projet.j2ee.service.AdministrateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administrateurs")
public class AdministrateurController {

    @Autowired
    private AdministrateurService administrateurService;

    @GetMapping
    public List<Administrateur> getAllAdministrateurs() {
        return administrateurService.getAllAdministrateurs();
    }

    @GetMapping("/{id}")
    public Administrateur getAdministrateurById(@PathVariable Long id) {
        return administrateurService.getAdministrateurById(id).orElse(null);
    }

    @PostMapping
    public Administrateur createAdministrateur(@RequestBody Administrateur administrateur) {
        return administrateurService.createAdministrateur(administrateur);
    }

    @PutMapping("/{id}")
    public Administrateur updateAdministrateur(@PathVariable Long id, @RequestBody Administrateur administrateur) {
        administrateur.setId_administrateur(id);
        return administrateurService.updateAdministrateur(administrateur);
    }

    @DeleteMapping("/{id}")
    public void deleteAdministrateur(@PathVariable Long id) {
        administrateurService.deleteAdministrateur(id);
    }
}
