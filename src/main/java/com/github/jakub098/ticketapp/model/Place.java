package com.github.jakub098.ticketapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="place")
public class Place {

    @Id
    @Column(name = "id_place", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_place_address")
    private PlaceAddress placeAddress;


}
