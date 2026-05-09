package com.example.reparaciones.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "reparaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reparaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private Long tecnicoId;

    @Column (nullable = false)
    private Long solicitudId;

    @Column(nullable = false, length = 150)
    private String descripcion;

    @Column(nullable = false)
    private double costo;

    private Date fechaReparacion;
}

