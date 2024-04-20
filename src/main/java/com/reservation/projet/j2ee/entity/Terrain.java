package com.reservation.projet.j2ee.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Terrain")
public class Terrain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_terrain;
    private String nom;
    private String adresse;
    private String description;
    private String image;

    @JsonIgnore // Ignore lors de la sérialisation pour éviter une boucle infinie
    @OneToMany(mappedBy = "terrain", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations = new ArrayList<>();

    @JsonManagedReference // Pour éviter une boucle infinie lors de la sérialisation
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_horaire")
    private Horaire horaire; // Lien vers l'horaire spécifique pour ce terrain
}
