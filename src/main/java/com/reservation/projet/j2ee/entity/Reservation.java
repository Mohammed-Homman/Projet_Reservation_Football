package com.reservation.projet.j2ee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reservation;

    @ManyToOne
    @JoinColumn(name = "id")
    private Utilisateur utilisateur;

    private String date_reservation;
    private String heure_reservation;
    private String statut;

    // Nouveaux champs pour le nombre de joueurs
    private int nombre_joueurs_actuels;
    private int nombre_joueurs_max;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_terrain")
    private Terrain terrain;

    @ManyToOne
    @JoinColumn(name = "id_horaire")
    private Horaire horaire;
}
