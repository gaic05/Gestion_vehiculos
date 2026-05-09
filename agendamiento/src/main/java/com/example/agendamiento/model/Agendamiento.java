package com.example.agendamiento.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "agendamientos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Agendamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long vehiculoId;

    @Column(nullable = false)
    private Long usuarioId;

    private Date fechaHora;

    @Column(nullable = false, length = 150)
    private String descripcion;
}
