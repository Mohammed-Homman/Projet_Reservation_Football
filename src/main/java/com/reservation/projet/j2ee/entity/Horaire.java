package com.reservation.projet.j2ee.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Horaire")
public class Horaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_horaire;
    private Date Jour;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime debut;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime fin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_terrain")
    private Terrain terrain;

    @OneToMany(mappedBy = "horaire")
    private List<Reservation> reservations;
}
