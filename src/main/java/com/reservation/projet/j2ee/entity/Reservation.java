package com.reservation.projet.j2ee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reservation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private Utilisateur utilisateur;

    @Column(name = "date_reservation")
    private String dateReservation;
    private String heure_reservation;
    private String statut;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_terrain")
    private Terrain terrain;
}
