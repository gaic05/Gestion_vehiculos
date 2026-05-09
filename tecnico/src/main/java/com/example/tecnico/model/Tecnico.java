package com.example.tecnico.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tecnicos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private  String nombre;

    @Column(nullable = false, length = 150)
    private  String especialidad;

    @Column(nullable = false, length = 12)
    private String telefono;

    @Column(nullable = false, length = 255)
    private String email;
}

