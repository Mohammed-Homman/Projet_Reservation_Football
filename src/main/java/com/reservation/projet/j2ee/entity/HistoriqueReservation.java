package com.reservation.projet.j2ee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "historiqueReservation")
public class HistoriqueReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id_historique;
    @ManyToOne
    @JoinColumn(name = "id_reservation")
    private Reservation reservation;
    @ManyToOne
    @JoinColumn(name = "id")
    private Utilisateur utilisateur;
}
